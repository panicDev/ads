package com.cid.ads.colorPicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.cid.ads.colorPicker.view.ColorPickerViewColors
import com.cid.ads.colorPicker.view.ColorPickerViewDefaults
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.modalPage.ModalPageColors
import com.cid.ads.modalPage.ModalPageDefaults

/**
 * Contains the default values used by [ColorPicker].
 */
object ColorPickerDefaults {

    /**
     * Create a [ColorPickerColors] that represents the default container and content colors.
     *
     * @param colorPickerViewColors The color configurations for the color picker view.
     * @param pageColors The color configurations for modal page associated with the color picker.
     */
    @Composable
    fun colors(
        colorPickerViewColors: ColorPickerViewColors = ColorPickerViewDefaults.colors(),
        pageColors: ModalPageColors = ModalPageDefaults.colors(),
        titleColors: Color = AkaTheme.colorScheme.onSurface
    ) = ColorPickerColors(
        colorPickerViewColors = colorPickerViewColors,
        pageColors = pageColors,
        titleColors = titleColors
    )
}

/**
 * Represents the container and content colors used in a color picker in different states.
 *
 * @param colorPickerViewColors The color configurations for the color picker view.
 * @param pageColors The color configurations for modal page associated with the color picker.
 */
@Immutable
class ColorPickerColors internal constructor(
    internal val colorPickerViewColors: ColorPickerViewColors,
    internal val pageColors: ModalPageColors,
    internal val titleColors: Color
)