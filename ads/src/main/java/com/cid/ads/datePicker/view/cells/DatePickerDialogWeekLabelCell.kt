package com.cid.ads.datePicker.view.cells

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowHeightSizeClass
import com.cid.ads.datePicker.view.DatePickerDayOfWeekCellColors
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text

/**
 * A composable function that represents a week label cell in a date picker dialog.
 *
 * @param label The label text to be displayed, typically representing the day of the week.
 * @param modifier The modifier to be applied to the composable.
 * @param colors The colors to be used for the week label cell, including the day of the week label color.
 */
@Composable
internal fun DatePickerDialogWeekLabelCell(
    label: String,
    modifier: Modifier = Modifier,
    colors: DatePickerDayOfWeekCellColors,
) {
    val windowHeightSizeClass = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    val sizeModifier =
        if (windowHeightSizeClass == WindowHeightSizeClass.COMPACT)
            modifier.size(34.dp, 24.dp)
        else
            modifier
                .height(24.dp)
                .padding(
                    horizontal = AkaTheme.spacing.size4,
                    vertical = AkaTheme.spacing.size2
                )

    Box(
        modifier = sizeModifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = AkaTheme.typography.labelMedium.copy(fontWeight = FontWeight.ExtraBold),
            color = colors.dayOfWeekLabelColor
        )
    }
}