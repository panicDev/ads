package com.cid.ads.colorPicker.view.root

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cid.ads.foundation.AkaTheme

/**
 * A composable function that arranges two columns of content horizontally within a row.
 *
 * @param leftColumn A left column views.
 * @param rightColumn A right column views.
 */
@Composable
fun HorizontalColorView(
    leftColumn: @Composable RowScope.() -> Unit,
    rightColumn: @Composable RowScope.() -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size16)
    ) {
        leftColumn()
        rightColumn()
    }
}