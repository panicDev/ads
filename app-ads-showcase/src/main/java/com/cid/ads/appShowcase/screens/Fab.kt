package com.cid.ads.appShowcase.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.navigation.NavController
import com.cid.ads.fab.Fab
import com.cid.ads.fab.FabDefaults
import com.cid.ads.fab.SmallFab
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Input
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.plus.Plus
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Fab : Screen {

    override val name: String = "FABs"

    override val image: Int = R.drawable.fab

    override val navigation: String = "fab"

    @Composable
    override fun Content(navController: NavController?) {

        val (expandable, onExpandableChange) = remember { mutableStateOf(true) }
        val labelState = rememberTextFieldState("Fab")

        val sizeStates = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false)
            )
        }

        val styleStates = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false),
                mutableStateOf(false),
                mutableStateOf(false)
            )
        }

        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() }
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxWidth()
                    .padding(it)
            ) {
                SampleRow(text = "Sample", firstItem = true) {
                    when {
                        sizeStates[0].value -> {
                            Fab(
                                icon = rememberVectorPainter(image = IdsSymbols.Default.Plus),
                                title = labelState.text.toString(),
                                expanded = expandable,
                                colors = when {
                                    styleStates[0].value -> FabDefaults.neutralColors()
                                    styleStates[1].value -> FabDefaults.primaryColors()
                                    styleStates[2].value -> FabDefaults.secondaryColors()
                                    styleStates[3].value -> FabDefaults.tertiaryColors()
                                    else -> FabDefaults.neutralColors()
                                },
                                onClick = {}
                            )

                        }

                        sizeStates[1].value -> {
                            SmallFab(
                                icon = rememberVectorPainter(image = IdsSymbols.Default.Plus),
                                colors = when {
                                    styleStates[0].value -> FabDefaults.neutralColors()
                                    styleStates[1].value -> FabDefaults.primaryColors()
                                    styleStates[2].value -> FabDefaults.secondaryColors()
                                    styleStates[3].value -> FabDefaults.tertiaryColors()
                                    else -> FabDefaults.neutralColors()
                                },
                                onClick = {}
                            )
                        }
                    }
                }
                if (sizeStates[0].value) {
                    FormItem(
                        subhead = { Subhead(text = "Label") },
                        content = { Input(state = labelState) }
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Size") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Default",
                                selected = sizeStates[0].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                }
                            )
                            RadioButton(
                                text = "Small",
                                selected = sizeStates[1].value,
                                onSelectedChange = {
                                    sizeStates.forEachIndexed { index, mutableState ->
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
                                text = "Neutral",
                                selected = styleStates[0].value,
                                onSelectedChange = {
                                    styleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                }
                            )
                            RadioButton(
                                text = "Primary",
                                selected = styleStates[1].value,
                                onSelectedChange = {
                                    styleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                }
                            )
                            RadioButton(
                                text = "Secondary",
                                selected = styleStates[2].value,
                                onSelectedChange = {
                                    styleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 2
                                    }
                                }
                            )
                            RadioButton(
                                text = "Tertiary",
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
                if (sizeStates[0].value) {
                    FormItem(
                        subhead = { Subhead(text = "Settings") },
                        content = {
                            Checkboxes {
                                Checkbox(
                                    text = "Expanded",
                                    checked = expandable,
                                    onCheckedChange = onExpandableChange
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}