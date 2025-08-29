package com.cid.ads.charts.pie

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.cid.ads.charts.util.ChartStyle
import com.cid.ads.foundation.AkaTheme

/**
 * Contains the default values used by [PieChart].
 */
object PieChartDefaults {

    /**
     * Creates a [ChartStyle] that represents the default style used in a [PieChart].
     *
     * @param labelStyle The label text style of this pie chart.
     * @param labelColor The label color of this pie chart.
     */
    @Composable
    fun style(
        labelStyle: TextStyle = AkaTheme.typography.labelLarge,
        labelColor: Color = Color.White
    ): ChartStyle =
        ChartStyle(
            titleStyle = AkaTheme.typography.titleMedium,
            titleColor = AkaTheme.colorScheme.onSurface,
            subtitleStyle = AkaTheme.typography.headlineMedium,
            subtitleColor = AkaTheme.colorScheme.onSurface,
            labelStyle = labelStyle,
            labelColor = labelColor
        )
}