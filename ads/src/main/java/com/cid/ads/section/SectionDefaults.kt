package com.cid.ads.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.listItem.ListItemColors
import com.cid.ads.listItem.ListItemDefaults
import com.cid.ads.listItem.ListItemSizes

object SectionDefaults {

    @Composable
    fun colors(
        containerColor: Color = AkaTheme.colorScheme.surfaceContainer,
        titleTextColor: Color = AkaTheme.colorScheme.primary,
        detailsTextColor: Color = AkaTheme.colorScheme.onSurfaceVariant,
        captionTextColor: Color = AkaTheme.colorScheme.onSurfaceVariant,
        itemColors: ListItemColors = ListItemDefaults.colors()
    ) = SectionColors(
        containerColor = containerColor,
        titleTextColor = titleTextColor,
        detailsTextColor = detailsTextColor,
        captionTextColor = captionTextColor,
        itemColors = itemColors
    )

    @Composable
    fun sizes(
        shape: Shape = AkaTheme.shapes.shape18,
        titleTextStyle: TextStyle = AkaTheme.typography.labelMedium,
        detailsTextStyle: TextStyle = AkaTheme.typography.bodyMedium,
        captionTextStyle: TextStyle = AkaTheme.typography.bodySmall,
        itemSizes: ListItemSizes = ListItemDefaults.sizes()
    ) = SectionSizes(
        shape = shape,
        titleTextStyle = titleTextStyle,
        detailsTextStyle = detailsTextStyle,
        captionTextStyle = captionTextStyle,
        itemSizes = itemSizes
    )
}

@Immutable
class SectionColors internal constructor(
    internal val containerColor: Color,
    internal val titleTextColor: Color,
    internal val detailsTextColor: Color,
    internal val captionTextColor: Color,
    internal val itemColors: ListItemColors
)

@Immutable
class SectionSizes internal constructor(
    internal val shape: Shape,
    internal val titleTextStyle: TextStyle,
    internal val detailsTextStyle: TextStyle,
    internal val captionTextStyle: TextStyle,
    internal val itemSizes: ListItemSizes
)
