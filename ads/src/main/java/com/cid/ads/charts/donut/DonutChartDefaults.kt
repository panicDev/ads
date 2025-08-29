package com.cid.ads.charts.donut

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.cid.ads.charts.util.ChartStyle
import com.cid.ads.foundation.AkaTheme

/**
 * Contains the default values used by [DonutChart].
 */
object DonutChartDefaults {

    /**
     * Creates a [ChartStyle] that represents the default style used in a [DonutChart].
     *
     * @param titleStyle The title text style of this donut chart.
     * @param titleColor The title color of this donut chart.
     * @param subtitleStyle The subtitle text style of this donut chart.
     * @param subtitleColor The subtitle color of this donut chart.
     * @param labelStyle The label text style of this donut chart.
     * @param labelColor The label color of this donut chart.
     */
    @Composable
    fun style(
        titleStyle: TextStyle = AkaTheme.typography.titleSmall,
        titleColor: Color = AkaTheme.colorScheme.onSurface,
        subtitleStyle: TextStyle = AkaTheme.typography.headlineMedium,
        subtitleColor: Color = AkaTheme.colorScheme.onSurface,
        labelStyle: TextStyle = AkaTheme.typography.labelLarge,
        labelColor: Color = Color.White
    ): ChartStyle =
        ChartStyle(
            titleStyle = titleStyle,
            titleColor = titleColor,
            subtitleStyle = subtitleStyle,
            subtitleColor = subtitleColor,
            labelStyle = labelStyle,
            labelColor = labelColor
        )

}