package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.menu.DropdownMenuItem
import com.cid.ads.scafold.Scaffold
import com.cid.ads.topAppBar.Action
import com.cid.ads.topAppBar.Avatar
import com.cid.ads.topAppBar.IconButton
import com.cid.ads.topAppBar.More
import com.cid.ads.topAppBar.TopAppBar
import com.cid.adsSymbols.arrow.left.ArrowLeft
import com.cid.adsSymbols.bell.Bell
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.magnifyingGlass.MagnifyingGlass
import com.cid.ads.appShowcase.R

object TopAppBar : Screen {
    override val name: String = "Top app bar"

    override val image: Int = R.drawable.top_app_bar

    override val navigation: String = "topAppBar"

    @Composable
    override fun Content(navController: NavController?) {
        val (counter, onCounterChange) = remember { mutableStateOf(false) }

        val (left, onLeftChange) = remember { mutableStateOf(true) }
        val leftStates = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false),
            )
        }

        val (right, onRightChange) = remember { mutableStateOf(true) }

        val rightStates = remember {
            listOf(
                mutableStateOf(false),
                mutableStateOf(true),
                mutableStateOf(false),
                mutableStateOf(false),
            )
        }
        val (expanded, onExpandedChange) = remember { mutableStateOf(false) }

        var showSettings by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    leading = if (left) {
                        {
                            when {
                                leftStates[0].value -> {
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.ArrowLeft),
                                        onClick = { navController?.navigateUp() }
                                    )
                                }

                                leftStates[1].value -> {
                                    Avatar(
                                        avatarUrl = "https://loremflickr.com/320/240".toUri(),
                                        onClick = { navController?.navigateUp() }
                                    )
                                }
                            }
                        }
                    } else null,
                    title = name,
                    counterValue = if (counter) 10 else 0,
                    trailing = if (right) {
                        {
                            when {
                                rightStates[0].value -> {
                                    Action(
                                        text = "Action",
                                        onClick = {}
                                    )
                                }

                                rightStates[1].value -> {
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.Bell),
                                        onClick = {
                                            showSettings = true
                                        }
                                    )
                                }

                                rightStates[2].value -> {
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.Bell),
                                        onClick = {}
                                    )
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.MagnifyingGlass),
                                        onClick = {}
                                    )
                                }

                                rightStates[3].value -> {
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.Bell),
                                        onClick = {}
                                    )
                                    IconButton(
                                        icon = rememberVectorPainter(IdsSymbols.Default.MagnifyingGlass),
                                        onClick = {}
                                    )
                                    More(
                                        expanded = expanded,
                                        onExpandedChange = onExpandedChange,
                                        menuItems = {
                                            DropdownMenuItem(
                                                text = "Menu Action 1",
                                                onClick = { onExpandedChange(false) }
                                            )
                                            DropdownMenuItem(
                                                text = "Menu Action 1",
                                                onClick = { onExpandedChange(false) }
                                            )
                                            DropdownMenuItem(
                                                text = "Menu Action 1",
                                                onClick = { onExpandedChange(false) }
                                            )
                                            DropdownMenuItem(
                                                text = "Menu Action 1",
                                                onClick = { onExpandedChange(false) }
                                            )
                                            DropdownMenuItem(
                                                text = "Menu Action 1",
                                                onClick = { onExpandedChange(false) }
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    } else null
                )
            }
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                if (left) {
                    FormItem(
                        subhead = { Subhead(text = "Leading") },
                        content = {
                            RadioButtons {
                                RadioButton(
                                    text = "Icon button",
                                    selected = leftStates[0].value,
                                    onSelectedChange = {
                                        leftStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 0
                                        }
                                    }
                                )
                                RadioButton(
                                    text = "Avatar",
                                    selected = leftStates[1].value,
                                    onSelectedChange = {
                                        leftStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 1
                                        }
                                    }
                                )
                            }
                        }
                    )
                }
                if (right) {
                    FormItem(
                        subhead = { Subhead(text = "Trailing") },
                        content = {
                            RadioButtons {
                                RadioButton(
                                    text = "Action",
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
                                    text = "Icons",
                                    selected = rightStates[2].value,
                                    onSelectedChange = {
                                        rightStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 2
                                        }
                                    }
                                )
                                RadioButton(
                                    text = "Icons with overflow",
                                    selected = rightStates[3].value,
                                    onSelectedChange = {
                                        rightStates.forEachIndexed { index, mutableState ->
                                            mutableState.value = index == 3
                                        }
                                    }
                                )
                            }
                        }
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
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
                                text = "Counter",
                                checked = counter,
                                onCheckedChange = onCounterChange
                            )
                        }
                    }
                )
            }
        }
    }
}