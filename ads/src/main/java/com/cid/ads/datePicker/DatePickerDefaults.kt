package com.cid.ads.datePicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.cid.ads.alert.AlertColors
import com.cid.ads.alert.AlertsDefaults
import com.cid.ads.counter.CounterColors
import com.cid.ads.datePicker.view.DatePickerViewColors
import com.cid.ads.datePicker.view.IdsDatePickerViewDefaults

/**
 * Contains the default values used by [DatePicker].
 */
object IdsDatePickerDefaults {

    /**
     * Create a [CounterColors] that represents the default container and content used in a [DatePicker].
     *
     * @param datePickerViewColors The colors used for the date picker view.
     * @param alertColors The colors used for the alert dialog of the date picker.
     */
    @Composable
    fun colors(
        datePickerViewColors: DatePickerViewColors = IdsDatePickerViewDefaults.colors(),
        alertColors: AlertColors = AlertsDefaults.colors()
    ) = DatePickerColors(
        datePickerViewColors = datePickerViewColors,
        alertColors = alertColors
    )
}

/**
 * Represents the container and content colors used in a [DatePicker] in different states.
 *
 * @property datePickerViewColors The colors used for the date picker view.
 * @property alertColors The colors used for the alert dialog of the date picker.
 */
@Immutable
class DatePickerColors internal constructor(
    internal val datePickerViewColors: DatePickerViewColors,
    internal val alertColors: AlertColors
)
