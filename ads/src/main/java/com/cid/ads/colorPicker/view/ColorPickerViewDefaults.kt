package com.cid.ads.colorPicker.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.segmentedControls.tabs.SegmentedTabsColors
import com.cid.ads.segmentedControls.tabs.SegmentedTabsDefaults
import com.cid.ads.slider.SliderColors
import com.cid.ads.slider.SliderDefaults

/**
 * Contains the default values used by [ColorPickerView].
 */
object ColorPickerViewDefaults {

    /**
     * Create a [ColorPickerViewColors] that represents the default container and content colors.
     *
     * @param selectorBorderColor The color of the border for the selector.
     * @param selectorThumbBorderColor The color of the border for the selector thumb.
     * @param saturationValueThumbColor The color of the thumb for the saturation and value sliders.
     * @param slidersColors The colors used for the sliders.
     * @param segmentedTabsColors The colors used for the segmented tabs.
     */
    @Composable
    fun colors(
        selectorBorderColor: Color = AkaTheme.colorScheme.outlineVariant,
        selectorThumbBorderColor: Color = AkaTheme.colorScheme.surface,
        saturationValueThumbColor: Color = AkaTheme.colorScheme.surface,
        slidersColors: SliderColors = SliderDefaults.colors(),
        segmentedTabsColors: SegmentedTabsColors = SegmentedTabsDefaults.colors(),
    ) = ColorPickerViewColors(
        selectorBorderColor = selectorBorderColor,
        selectorThumbBorderColor = selectorThumbBorderColor,
        saturationValueThumbColor = saturationValueThumbColor,
        slidersColors = slidersColors,
        segmentedTabsColors = segmentedTabsColors
    )
}

/**
 * Represents the container and content colors used in a [ColorPickerView] in different states.
 *
 * @property selectorBorderColor The color of the border for the selector.
 * @property selectorThumbBorderColor The color of the border for the selector thumb.
 * @property saturationValueThumbColor The color of the thumb for the saturation and value sliders.
 * @property slidersColors The colors used for the sliders.
 * @property segmentedTabsColors The colors used for the segmented tabs.
 */
@Immutable
class ColorPickerViewColors internal constructor(
    internal val selectorBorderColor: Color,
    internal val selectorThumbBorderColor: Color,
    internal val saturationValueThumbColor: Color,
    internal val slidersColors: SliderColors,
    internal val segmentedTabsColors: SegmentedTabsColors
)