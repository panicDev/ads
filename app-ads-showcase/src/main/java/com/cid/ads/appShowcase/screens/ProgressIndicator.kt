package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.progressIndicator.CircularProgressIndicator
import com.cid.ads.progressIndicator.LinearProgressIndicator
import com.cid.ads.progressIndicator.ProgressIndicatorDefaults
import com.cid.ads.slider.continuous.Slider
import com.cid.ads.text.Text
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object ProgressIndicator : Screen {

    override val name: String = "Progress indicator"

    override val image: Int = R.drawable.progress_indicator

    override val navigation: String = "progress"

    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        SampleScaffold(
            title = name,
            topAppBarScrollBehavior = topAppBarScrollBehavior,
            onBackClick = {
                navController?.navigateUp()
            }
        ) {
            val (indeterminate, onIndeterminateChange) = remember { mutableStateOf(false) }
            val (content, onContentChange) = remember { mutableStateOf(false) }
            val (progress, onProgressChange) = remember { mutableFloatStateOf(5f) }
            val linearSize = ProgressIndicatorDefaults.linearLarge()
            var linearSizeState by remember { mutableStateOf(linearSize) }
            val circularSize = ProgressIndicatorDefaults.circularLarge()
            var circularSizeState by remember { mutableStateOf(circularSize) }

            val sizeStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false),
                    mutableStateOf(false)
                )
            }
            val largeLinear = ProgressIndicatorDefaults.linearLarge()
            val mediumLinear = ProgressIndicatorDefaults.linearMedium()
            val smallLinear = ProgressIndicatorDefaults.linearSmall()
            val largeCircular = ProgressIndicatorDefaults.circularLarge()
            val mediumCircular = ProgressIndicatorDefaults.circularMedium()
            val smallCircular = ProgressIndicatorDefaults.circularSmall()

            val typeStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .verticalScroll(rememberScrollState())
                    .padding(it),
            ) {
                SampleRow(text = "Sample", firstItem = true) {
                    Column {
                        when {
                            typeStates[0].value -> {
                                if (indeterminate) {
                                    CircularProgressIndicator(sizes = circularSizeState)
                                } else {
                                    CircularProgressIndicator(
                                        progress = { progress },
                                        maxValue = { 10f },
                                        sizes = circularSizeState,
                                        content = content
                                    )
                                }
                            }

                            typeStates[1].value -> {
                                if (indeterminate) {
                                    LinearProgressIndicator(
                                        modifier = Modifier.fillMaxWidth(),
                                        sizes = linearSizeState
                                    )
                                } else {
                                    LinearProgressIndicator(
                                        progress = { progress },
                                        maxValue = { 10f },
                                        modifier = Modifier.fillMaxWidth(),
                                        sizes = linearSizeState,
                                        content = content
                                    )
                                }
                            }
                        }
                    }
                }
                if (!indeterminate) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = AkaTheme.spacing.size16),
                        text = "Progress value",
                        style = AkaTheme.typography.labelLarge,
                        color = AkaTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(AkaTheme.spacing.size2))
                    Slider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AkaTheme.spacing.size16),
                        value = progress,
                        onValueChange = onProgressChange,
                        valueRange = 0f..10f
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Type") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Circular",
                                selected = typeStates[0].value,
                                onSelectedChange = {
                                    typeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                }
                            )
                            RadioButton(
                                text = "Linear",
                                selected = typeStates[1].value,
                                onSelectedChange = {
                                    typeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                }
                            )
                        }
                    }
                )
                FormItem(
                    subhead = { Subhead(text = "Size") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Large",
                                selected = sizeStates[0].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                    linearSizeState = largeLinear
                                    circularSizeState = largeCircular
                                }
                            )
                            RadioButton(
                                text = "Medium",
                                selected = sizeStates[1].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                    linearSizeState = mediumLinear
                                    circularSizeState = mediumCircular
                                }
                            )
                            RadioButton(
                                text = "Small",
                                selected = sizeStates[2].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 2
                                    }
                                    linearSizeState = smallLinear
                                    circularSizeState = smallCircular
                                }
                            )
                        }
                    }
                )
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            Checkbox(
                                text = "Indeterminate",
                                checked = indeterminate,
                                onCheckedChange = onIndeterminateChange
                            )
                            if (!indeterminate) {
                                Checkbox(
                                    text = "Content",
                                    checked = content,
                                    onCheckedChange = onContentChange
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}