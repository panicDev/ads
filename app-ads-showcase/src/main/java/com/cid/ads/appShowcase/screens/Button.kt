package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.cid.ads.button.Button
import com.cid.ads.button.ButtonDefaults
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Input
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.adsSymbols.chevron.right.ChevronRight
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.plus.Plus
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Button : Screen {
    override val name: String = "Button"

    override val image: Int = R.drawable.button

    override val navigation: String = "button"

    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() },
            topAppBarScrollBehavior = topAppBarScrollBehavior,
        ) {
            val labelState = rememberTextFieldState("Button")
            val (leading, onLeadingChange) = remember { mutableStateOf(false) }
            val (trailing, onTrailingChange) = remember { mutableStateOf(false) }
            val (additionInfo, onAdditionalInfoChange) = remember { mutableStateOf(false) }
            val additionalInfoState = rememberTextFieldState("Addition info")
            val size = ButtonDefaults.largeSizes()
            var sizeState by remember { mutableStateOf(size) }
            val (enabled, onEnabledChange) = remember { mutableStateOf(true) }
            val (loading, onLoadingChange) = remember { mutableStateOf(false) }

            val colors = ButtonDefaults.primaryColors()
            var colorsState by remember { mutableStateOf(colors) }

            val buttonStyleStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false),
                    mutableStateOf(false),
                    mutableStateOf(false)
                )
            }

            val sizeStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false),
                    mutableStateOf(false)
                )
            }
            val large = ButtonDefaults.largeSizes()
            val medium = ButtonDefaults.mediumSizes()
            val small = ButtonDefaults.smallSizes()

            val primary = ButtonDefaults.primaryColors()
            val secondary = ButtonDefaults.secondaryColors()
            val tertiary = ButtonDefaults.tertiaryColors()
            val outlined = ButtonDefaults.outlinedColors()
            Column(
                Modifier
                    .fillMaxSize()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .verticalScroll(rememberScrollState())
                    .padding(it)
                    .navigationBarsPadding()
            ) {
                SampleRow(
                    text = "Sample",
                    firstItem = true
                ) {
                    Button(
                        text = labelState.text.toString(),
                        sizes = sizeState,
                        colors = colorsState,
                        enabled = enabled,
                        loading = loading,
                        additionInfoText = if (additionInfo) additionalInfoState.text.toString() else null,
                        leadingIcon = if (leading)
                            rememberVectorPainter(image = IdsSymbols.Default.Plus)
                        else null,
                        trailingIcon = if (trailing)
                            rememberVectorPainter(image = IdsSymbols.Default.ChevronRight)
                        else null,
                        onClick = {}
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Label") },
                    content = { Input(state = labelState) }
                )
                if (additionInfo) {
                    FormItem(
                        subhead = { Subhead(text = "Additional info") },
                        content = { Input(state = additionalInfoState) }
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Style") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Primary",
                                selected = buttonStyleStates[0].value,
                                onSelectedChange = {
                                    buttonStyleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                    colorsState = primary
                                }
                            )
                            RadioButton(
                                text = "Secondary",
                                selected = buttonStyleStates[1].value,
                                onSelectedChange = {
                                    buttonStyleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                    colorsState = secondary
                                }
                            )
                            RadioButton(
                                text = "Tertiary",
                                selected = buttonStyleStates[2].value,
                                onSelectedChange = {
                                    buttonStyleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 2
                                    }
                                    colorsState = tertiary
                                }
                            )
                            RadioButton(
                                text = "Outlined",
                                selected = buttonStyleStates[3].value,
                                onSelectedChange = {
                                    buttonStyleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 3
                                    }
                                    colorsState = outlined
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
                                    sizeState = large
                                }
                            )
                            RadioButton(
                                text = "Medium",
                                selected = sizeStates[1].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                    sizeState = medium
                                }
                            )
                            RadioButton(
                                text = "Small",
                                selected = sizeStates[2].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 2
                                    }
                                    sizeState = small
                                }
                            )
                        }
                    }
                )
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            if (sizeState != small) {
                                Checkbox(
                                    text = "Additional info",
                                    checked = additionInfo,
                                    onCheckedChange = onAdditionalInfoChange
                                )
                            }
                            Checkbox(
                                text = "Leading",
                                checked = leading,
                                onCheckedChange = onLeadingChange
                            )
                            Checkbox(
                                text = "Trailing",
                                checked = trailing,
                                onCheckedChange = onTrailingChange
                            )
                            Checkbox(
                                text = "Loading",
                                checked = loading,
                                onCheckedChange = onLoadingChange
                            )
                            Checkbox(
                                text = "Enabled",
                                checked = enabled,
                                onCheckedChange = onEnabledChange
                            )
                        }
                    }
                )
            }
        }
    }
}