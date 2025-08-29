package com.cid.ads.timePicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.cid.ads.alert.AlertColors
import com.cid.ads.alert.AlertSizes
import com.cid.ads.alert.AlertsDefaults
import com.cid.ads.timePicker.view.dial.DialTimePickerViewColors
import com.cid.ads.timePicker.view.dial.DialTimePickerViewDefaults
import com.cid.ads.timePicker.view.dial.DialTimePickerViewSizes
import com.cid.ads.timePicker.view.wheel.WheelTimePickerViewColors
import com.cid.ads.timePicker.view.wheel.WheelTimePickerViewDefaults
import com.cid.ads.timePicker.view.wheel.WheelTimePickerViewSizes

/**
 * Contains all default values used by [TimePicker]
 */
object TimePickerDefaults {

    /**
     * Create and return a [TimePickerColors] instance with the specified colors.
     *
     * This function allows customizing the colors used in the time picker components.
     *
     * @param wheelTimePickerViewColors The colors for the wheel time picker view.
     * @param dialTimePickerViewColors The colors for the dial time picker view.
     * @param alertColors The colors for the alert dialog.
     */
    @Composable
    fun colors(
        wheelTimePickerViewColors: WheelTimePickerViewColors = WheelTimePickerViewDefaults.colors(),
        dialTimePickerViewColors: DialTimePickerViewColors = DialTimePickerViewDefaults.colors(),
        alertColors: AlertColors = AlertsDefaults.colors()
    ): TimePickerColors = TimePickerColors(
        wheelTimePickerViewColors = wheelTimePickerViewColors,
        dialTimePickerViewColors = dialTimePickerViewColors,
        alertColors = alertColors
    )

    /**
     * Create and return a [TimePickerSizes] instance with the specified sizes.
     *
     * This function allows customizing the sizes used in the time picker components.
     *
     * @param wheelTimePickerViewSizes The sizes for the wheel time picker view.
     * @param dialTimePickerViewSizes The sizes for the dial time picker view.
     * @param alertSizes The sizes for the alert dialog.
     */
    @Composable
    fun sizes(
        wheelTimePickerViewSizes: WheelTimePickerViewSizes = WheelTimePickerViewDefaults.sizes(),
        dialTimePickerViewSizes: DialTimePickerViewSizes = DialTimePickerViewDefaults.sizes(),
        alertSizes: AlertSizes = AlertsDefaults.alertSizes()
    ): TimePickerSizes = TimePickerSizes(
        wheelTimePickerViewSizes = wheelTimePickerViewSizes,
        dialTimePickerViewSizes = dialTimePickerViewSizes,
        alertSizes = alertSizes
    )
}

/**
 * Immutable class representing the colors for the time picker components.
 *
 * This class holds the colors for the wheel time picker view, dial time picker view, and alert dialog.
 *
 * @param wheelTimePickerViewColors The colors for the wheel time picker view.
 * @param dialTimePickerViewColors The colors for the dial time picker view.
 * @param alertColors The colors for the alert dialog.
 */
@Immutable
class TimePickerColors(
    internal val wheelTimePickerViewColors: WheelTimePickerViewColors,
    internal val dialTimePickerViewColors: DialTimePickerViewColors,
    internal val alertColors: AlertColors
)

/**
 * Immutable class representing the sizes for the time picker components.
 *
 * This class holds the sizes for the wheel time picker view, dial time picker view, and alert sizes.
 *
 * @param wheelTimePickerViewSizes The sizes for the wheel time picker view.
 * @param dialTimePickerViewSizes The sizes for the dial time picker view.
 * @param alertSizes The sizes for the alert dialog.
 */
@Immutable
class TimePickerSizes(
    internal val wheelTimePickerViewSizes: WheelTimePickerViewSizes,
    internal val dialTimePickerViewSizes: DialTimePickerViewSizes,
    internal val alertSizes: AlertSizes
)