package com.cid.ads.select

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.cid.ads.input.Input
import com.cid.ads.input.InputColors
import com.cid.ads.input.InputSizes
import com.cid.ads.input.InputsDefaults
import com.cid.ads.menu.DropdownMenuItemScope
import com.cid.ads.menu.MenuColors
import com.cid.ads.menu.MenuDefaults
import com.cid.ads.menu.MenuSizes
import com.cid.adsSymbols.chevron.down.ChevronDown
import com.cid.adsSymbols.chevron.up.ChevronUp
import com.cid.adsSymbols.foundation.IdsSymbols

/**
 * A select element is useful for providing users with a list of options to choose from, offering
 * a compact and interactive interface for selecting items. It offers a straightforward
 * and effective method for data entry and navigation, making it an essential tool for enhancing
 * user experience and usability.
 *
 * @param state The currently selected item in the dropdown.
 * @param modifier The [Modifier] to be applied to this composable.
 * @param expanded Whether the dropdown menu is currently expanded.
 * @param onExpandedChange A callback to be invoked when the expanded state changes.
 * @param enabled Whether the dropdown is enabled or disabled.
 * @param placeholder An optional placeholder text to be shown when no item is selected.
 * @param isError Whether the input is in an error state.
 * @param isValid Whether the input is in a valid state.
 * @param leadingIcon An optional leading icon to be shown in the input field.
 * @param inputColors The colors to be used for the input field.
 * @param menuColors The colors to be used for the dropdown menu.
 * @param menuItems A composable lambda that defines the items to be displayed in the dropdown menu.
 */
@Composable
fun Select(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    placeholder: String? = null,
    isError: Boolean = false,
    isValid: Boolean = false,
    leadingIcon: Painter? = null,
    inputColors: InputColors = InputsDefaults.outlineColors(),
    inputSizes: InputSizes = InputsDefaults.sizes(),
    menuColors: MenuColors = MenuDefaults.colors(),
    menuSizes: MenuSizes = MenuDefaults.sizes(),
    menuItems: @Composable (DropdownMenuItemScope.() -> Unit)
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) {
        Input(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled),
            state = state,
            leadingIcon = leadingIcon,
            placeholder = placeholder,
            readOnly = true,
            isError = isError,
            isValid = isValid,
            enabled = enabled,
            colors = inputColors,
            sizes = inputSizes,
            trailingIcon = if (expanded) rememberVectorPainter(image = IdsSymbols.Default.ChevronUp)
            else rememberVectorPainter(image = IdsSymbols.Default.ChevronDown),
        )
        ExposedDropdownMenu(
            modifier = Modifier.exposedDropdownSize(),
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            colors = menuColors,
            sizes = menuSizes,
            content = menuItems
        )
    }
}