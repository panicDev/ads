package com.cid.ads.datePicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cid.ads.R
import com.cid.ads.alert.Action
import com.cid.ads.alert.Alert
import com.cid.ads.datePicker.view.DatePickerView
import com.cid.ads.datePicker.view.state.rememberDatePickerState
import com.cid.ads.datePicker.view.util.DatePickerConfig
import com.cid.ads.datePicker.view.util.DatePickerSelection

/**
 * A date picker is useful for selecting specific dates, providing users with a convenient and
 * intuitive interface for choosing from a calendar. It offers a straightforward and effective
 * method for date selection, making it an essential tool for enhancing user experience and ensuring
 * accurate data entry.
 *
 * @param selection The selection type for the date picker.
 * @param title Title that will be display at top of the picker
 * @param config The configuration for the date picker.
 * @param colors The colors used for the date picker.
 * @param onDismissRequest The callback to be invoked when the date picker dialog is dismissed.
 */
@Composable
fun DatePicker(
    selection: DatePickerSelection,
    title: String = stringResource(R.string.select_date),
    config: DatePickerConfig = DatePickerConfig(),
    colors: DatePickerColors = IdsDatePickerDefaults.colors(),
    onDismissRequest: () -> Unit,
) {
    val state = rememberDatePickerState(
        selection = selection,
        config = config
    )

    Alert(
        title = title,
        onDismissRequest = onDismissRequest,
        colors = colors.alertColors,
        confirmAction = {
            Action(
                title = stringResource(id = R.string.ok),
                onClick = {
                    state.onFinish()
                    onDismissRequest()
                }
            )
        },
        dismissAction = {
            Action(
                title = stringResource(id = R.string.cancel),
                onClick = {
                    onDismissRequest()
                }
            )
        }
    ) {
        DatePickerView(
            state = state,
            config = config,
            colors = colors.datePickerViewColors,
            onSelection = {
                state.processSelection(it)
            }
        )
    }
}