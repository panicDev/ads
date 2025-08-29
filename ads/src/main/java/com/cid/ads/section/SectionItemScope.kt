package com.cid.ads.section

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cid.ads.listItem.ListItem
import com.cid.ads.listItem.ListItemColors
import com.cid.ads.listItem.ListItemDefaults
import com.cid.ads.listItem.ListItemLeadingScope
import com.cid.ads.listItem.ListItemSizes
import com.cid.ads.listItem.ListItemTrailingScope

interface SectionItemScope : ColumnScope {
    val sizes: ListItemSizes
    val colors: ListItemColors
}

class SectionItemScopeWrapper(
    scope: ColumnScope,
    override val sizes: ListItemSizes,
    override val colors: ListItemColors,
) : SectionItemScope, ColumnScope by scope

@Composable
fun SectionItemScope.Item(
    modifier: Modifier = Modifier,
    title: String,
    subhead: String? = null,
    body: String? = null,
    isNew: Boolean = false,
    leading: (@Composable ListItemLeadingScope.() -> Unit)? = null,
    trailing: (@Composable ListItemTrailingScope.() -> Unit)? = null,
    divider: Boolean = false,
    enabled: Boolean = true,
    checked: Boolean = false,
    sizes: ListItemSizes = ListItemDefaults.sizes(),
    colors: ListItemColors = ListItemDefaults.colors(),
    onClick: (() -> Unit)? = null
) = ListItem(
    modifier = modifier,
    title = title,
    subhead = subhead,
    body = body,
    isNew = isNew,
    leading = leading,
    trailing = trailing,
    divider = divider,
    enabled = enabled,
    checked = checked,
    colors = colors,
    sizes = sizes,
    onClick = onClick
)