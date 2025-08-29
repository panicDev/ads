package com.cid.ads.datePicker.view.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.cid.ads.datePicker.view.DatePickerMonthCellColors
import com.cid.ads.datePicker.view.cells.DatePickerDialogMonthCell
import com.cid.ads.datePicker.view.util.Constants
import com.cid.ads.foundation.AkaTheme

/**
 * A composable function that represents a month grid in a date picker dialog.
 *
 * This function displays a grid of months, allowing users to select a month. The appearance and behavior
 * of the grid are customizable based on the provided parameters.
 *
 * @param monthLabels An array of strings representing the labels for the months.
 * @param currentMonth The index of the current month.
 * @param selectedMonth The index of the selected month.
 * @param colors The colors to be used for the month cells in the grid.
 * @param onMonthClick A callback function that is invoked when a month cell is clicked.
 */
@Composable
internal fun DatePickerDialogMonthGrid(
    monthLabels: Array<String>,
    currentMonth: Int,
    selectedMonth: Int,
    colors: DatePickerMonthCellColors,
    onMonthClick: (Int) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(Constants.MONTH_MODE_GRID_COLUMNS),
        verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size4),
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(monthLabels.size) {
                DatePickerDialogMonthCell(
                    month = monthLabels[it],
                    index = it,
                    enabled = true,
                    currentMonth = currentMonth == it,
                    selected = selectedMonth == it,
                    onMonthClick = onMonthClick,
                    colors = colors
                )
            }
        }
    )
}