package com.cid.ads.datePicker.view.cells

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.cid.ads.datePicker.view.DatePickerYearCellColors
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text

/**
 * A composable function that represents a year cell in a IDS date picker dialog.
 *
 * @param year The year to be displayed.
 * @param index The index of the year in the list of years.
 * @param currentYear A boolean indicating whether the year cell represents the current year.
 * @param selected A boolean indicating whether the year cell is selected.
 * @param colors The colors to be used for the year cell, including container, content, and indicator colors.
 * @param onYearClick A callback function that is invoked when the year cell is clicked.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
internal fun DatePickerDialogYearCell(
    year: String,
    index: Int,
    currentYear: Boolean,
    selected: Boolean,
    colors: DatePickerYearCellColors,
    onYearClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    var todayIndicatorSize by remember { mutableStateOf(IntSize.Zero) }
    val sizeDp = with(LocalDensity.current) { todayIndicatorSize.width.toDp() }

    Column(
        modifier = modifier
            .background(
                color = colors.containerColor(selected = selected),
                shape = AkaTheme.shapes.shape12
            )
            .clip(AkaTheme.shapes.shape12)
            .clickable { onYearClick(index) }
            .padding(
                horizontal = AkaTheme.spacing.size4,
                vertical = AkaTheme.spacing.size8
            )
            .onSizeChanged {
                todayIndicatorSize = it
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = year,
            style = AkaTheme.typography.labelLarge,
            color = colors.contentColor(selected = selected)
        )
        Box(
            modifier = Modifier
                .padding(top = AkaTheme.spacing.size2)
                .width(sizeDp * 0.6f)
                .height(2.dp)
                .background(
                    color = colors.indicatorColor(selected = selected, currentYear),
                    shape = AkaTheme.shapes.shape4
                )
        )
    }
}