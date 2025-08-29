package com.cid.ads.appShowcase.componets

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text

@Composable
fun SampleRow(
    firstItem: Boolean = false,
    lastItem: Boolean = false,
    text: String,
    content: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(
                top = if (firstItem) AkaTheme.spacing.size12 else AkaTheme.spacing.size8,
                bottom = if (lastItem) AkaTheme.spacing.size12 else AkaTheme.spacing.size8,
            )
            .padding(horizontal = AkaTheme.spacing.size16)
    ) {
        Text(
            text = text,
            style = AkaTheme.typography.labelMedium,
            color = AkaTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(AkaTheme.spacing.size4))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}