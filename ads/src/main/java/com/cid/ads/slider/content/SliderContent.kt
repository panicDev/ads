package com.cid.ads.slider.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.icon.Icon
import com.cid.ads.icon.IconDefaults
import com.cid.ads.icon.IconSizes
import com.cid.ads.slider.SliderColors
import com.cid.ads.text.Text

interface SliderContentScope {
    val enabled: Boolean
    val colors: SliderColors
}

class SliderContentScopeWrapper(
    override val enabled: Boolean,
    override val colors: SliderColors
) : SliderContentScope

@Composable
fun SliderContentScope.Text(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = AkaTheme.typography.bodyLarge
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = colors.contentColor
    )
}

@Composable
fun SliderContentScope.Icon(
    modifier: Modifier = Modifier,
    icon: Painter,
    sizes: IconSizes = IconDefaults.size28()
) {
    Icon(
        modifier = modifier,
        painter = icon,
        sizes = sizes,
        tint = colors.contentColor
    )
}