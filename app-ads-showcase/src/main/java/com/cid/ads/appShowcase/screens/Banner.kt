package com.cid.ads.appShowcase.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavController
import com.cid.ads.banner.Action
import com.cid.ads.banner.Banner
import com.cid.ads.banner.BannerDefaults
import com.cid.ads.banner.Button
import com.cid.ads.banner.Icon
import com.cid.ads.banner.IconButton
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Input
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.formItem.TextArea
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.globe.Globe
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold

object Banner : Screen {

    override val name: String = "Banner"

    override val image: Int = R.drawable.banner

    override val navigation: String = "banner"

    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() },
            topAppBarScrollBehavior = topAppBarScrollBehavior
        ) {
            val styleStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false),
                    mutableStateOf(false),
                    mutableStateOf(false),
                )
            }

            var title by remember { mutableStateOf(true) }
            val titleState = rememberTextFieldState("Title")

            var description by remember { mutableStateOf(true) }
            val descriptionState =
                rememberTextFieldState("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed laoreet imperdiet consectetur. Nam vitae massa a metus dignissim malesuada. Duis.")

            val (left, onLeftChange) = remember { mutableStateOf(false) }

            val (right, onRightChange) = remember { mutableStateOf(false) }
            val rightStates = remember {
                listOf(
                    mutableStateOf(true),
                    mutableStateOf(false),
                    mutableStateOf(false),
                )
            }

            val (actions, onActionsChange) = remember { mutableStateOf(false) }

            val (clickable, onClickableChange) = remember { mutableStateOf(false) }
            val onClick = {}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .animateContentSize()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AkaTheme.spacing.size16)
                            .padding(top = AkaTheme.spacing.size8),
                        text = "Sample",
                        style = AkaTheme.typography.labelMedium,
                        color = AkaTheme.colorScheme.onSurfaceVariant
                    )
                    Banner(
                        title = if (title) titleState.text.toString() else null,
                        message = if (description) descriptionState.text.toString() else null,
                        onClick = if (clickable) onClick else null,
                        leadingIcon = if (left) rememberVectorPainter(IdsSymbols.Default.Globe) else null,
                        trailing = if (right) when {
                            rightStates[0].value -> {
                                {
                                    IconButton {}
                                }
                            }

                            rightStates[1].value -> {
                                {
                                    Icon()
                                }
                            }

                            rightStates[2].value -> {
                                {
                                    Button(
                                        action = "Button"
                                    ) { }
                                }
                            }

                            else -> null
                        } else null,
                        actions = if (actions) {
                            {
                                Action(
                                    text = "Action 1"
                                ) { }
                                Action(
                                    text = "Action 2"
                                ) { }
                            }
                        } else null,
                        colors = when {
                            styleStates[0].value -> BannerDefaults.infoColors()
                            styleStates[1].value -> BannerDefaults.validColors()
                            styleStates[2].value -> BannerDefaults.warningColors()
                            styleStates[3].value -> BannerDefaults.errorColors()
                            else -> BannerDefaults.infoColors()
                        }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .navigationBarsPadding()
                ) {
                    FormItem(
                        modifier = Modifier.fillMaxWidth(),
                        subhead = { Subhead(text = "Style") },
                        content = {
                            RadioButtons {
                                RadioButton(
                                    text = "Info",
                                    selected = styleStates[0].value,
                                    onSelectedChange = {
                                        styleStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 0
                                        }
                                    }
                                )
                                RadioButton(
                                    text = "Valid",
                                    selected = styleStates[1].value,
                                    onSelectedChange = {
                                        styleStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 1
                                        }
                                    }
                                )
                                RadioButton(
                                    text = "Warning",
                                    selected = styleStates[2].value,
                                    onSelectedChange = {
                                        styleStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 2
                                        }
                                    }
                                )
                                RadioButton(
                                    text = "Error",
                                    selected = styleStates[3].value,
                                    onSelectedChange = {
                                        styleStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 3
                                        }
                                    }
                                )
                            }
                        }
                    )
                    if (title) {
                        FormItem(
                            subhead = { Subhead(text = "Title") },
                            content = { Input(state = titleState) }
                        )
                    }
                    if (description) {
                        FormItem(
                            subhead = { Subhead(text = "Message") },
                            content = { TextArea(state = descriptionState) }
                        )
                    }
                    if (right) {
                        FormItem(
                            modifier = Modifier.fillMaxWidth(),
                            subhead = { Subhead(text = "Trailing content") },
                            content = {
                                RadioButtons {
                                    RadioButton(
                                        text = "Icon button",
                                        selected = rightStates[0].value,
                                        onSelectedChange = {
                                            rightStates.forEachIndexed { index, mutableState ->
                                                mutableState.value = index == 0
                                            }
                                        }
                                    )
                                    RadioButton(
                                        text = "Icon",
                                        selected = rightStates[1].value,
                                        onSelectedChange = {
                                            rightStates.forEachIndexed { index, mutableState ->
                                                mutableState.value = index == 1
                                            }
                                        }
                                    )
                                    RadioButton(
                                        text = "Button",
                                        selected = rightStates[2].value,
                                        onSelectedChange = {
                                            rightStates.forEachIndexed { index, mutableState ->
                                                mutableState.value = index == 2
                                            }
                                        }
                                    )
                                }
                            }
                        )
                    }
                    FormItem(
                        modifier = Modifier.fillMaxWidth(),
                        subhead = { Subhead(text = "Settings") },
                        content = {
                            Checkboxes {
                                Checkbox(
                                    text = "Title",
                                    checked = title,
                                    onCheckedChange = { isChecked ->
                                        title = isChecked
                                        if (!description && !isChecked) description = true
                                    }
                                )
                                Checkbox(
                                    text = "Message",
                                    checked = description,
                                    onCheckedChange = { isChecked ->
                                        description = isChecked
                                        if (!title && !isChecked) title = true
                                    }
                                )
                                Checkbox(
                                    text = "Leading",
                                    checked = left,
                                    onCheckedChange = onLeftChange
                                )
                                Checkbox(
                                    text = "Trailing",
                                    checked = right,
                                    onCheckedChange = onRightChange
                                )
                                Checkbox(
                                    text = "Actions",
                                    checked = actions,
                                    onCheckedChange = onActionsChange
                                )
                                Checkbox(
                                    text = "Clickable",
                                    checked = clickable,
                                    onCheckedChange = onClickableChange
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}