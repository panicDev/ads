package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.navigation.NavController
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Subhead
import com.cid.ads.menu.DropdownMenuItem
import com.cid.ads.select.Select
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.image.Image
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Select : Screen {
    override val name: String = "Select"

    override val image: Int = R.drawable.select

    override val navigation: String = "select"

    @Composable
    override fun Content(navController: NavController?) {
        val selectedOption = rememberTextFieldState("")
        val (expanded, onExpandChange) = remember { mutableStateOf(false) }
        val (enabled, onEnabledChange) = remember { mutableStateOf(true) }
        val (isError, onIsErrorChange) = remember { mutableStateOf(false) }
        val (isValid, onIsValidChange) = remember { mutableStateOf(false) }
        val (icons, onIconsChange) = remember { mutableStateOf(false) }
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SampleRow(text = "Sample", firstItem = true) {
                    Select(
                        state = selectedOption,
                        expanded = expanded,
                        enabled = enabled,
                        isError = isError,
                        isValid = isValid,
                        onExpandedChange = onExpandChange,
                        menuItems = {
                            DropdownMenuItem(
                                text = "Option 1",
                                leadingIcon = if (icons) rememberVectorPainter(image = IdsSymbols.Default.Image) else null,
                                onClick = {
                                    selectedOption.setTextAndPlaceCursorAtEnd("Option 1")
                                    onExpandChange(false)
                                }
                            )
                            DropdownMenuItem(
                                text = "Option 2",
                                leadingIcon = if (icons) rememberVectorPainter(image = IdsSymbols.Default.Image) else null,
                                onClick = {
                                    selectedOption.setTextAndPlaceCursorAtEnd("Option 2")
                                    onExpandChange(false)
                                }
                            )
                            DropdownMenuItem(
                                text = "Option 3",
                                leadingIcon = if (icons) rememberVectorPainter(image = IdsSymbols.Default.Image) else null,
                                onClick = {
                                    selectedOption.setTextAndPlaceCursorAtEnd("Option 3")
                                    onExpandChange(false)
                                }
                            )
                            DropdownMenuItem(
                                text = "Option 4",
                                leadingIcon = if (icons) rememberVectorPainter(image = IdsSymbols.Default.Image) else null,
                                onClick = {
                                    selectedOption.setTextAndPlaceCursorAtEnd("Option 4")
                                    onExpandChange(false)
                                }
                            )
                            DropdownMenuItem(
                                text = "Option 5",
                                leadingIcon = if (icons) rememberVectorPainter(image = IdsSymbols.Default.Image) else null,
                                onClick = {
                                    selectedOption.setTextAndPlaceCursorAtEnd("Option 5")
                                    onExpandChange(false)
                                }
                            )
                        },
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            Checkbox(
                                text = "Enabled",
                                checked = enabled,
                                onCheckedChange = onEnabledChange
                            )
                            Checkbox(
                                text = "Valid",
                                checked = isValid,
                                onCheckedChange = onIsValidChange
                            )
                            Checkbox(
                                text = "Error",
                                checked = isError,
                                onCheckedChange = onIsErrorChange
                            )
                            Checkbox(
                                text = "Icons",
                                checked = icons,
                                onCheckedChange = onIconsChange
                            )
                        }
                    }
                )
            }
        }
    }
}