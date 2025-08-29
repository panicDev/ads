package com.cid.ads.colorPicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.cid.ads.R
import com.cid.ads.colorPicker.view.ColorPickerView
import com.cid.ads.colorPicker.view.util.ColorPickerState
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.modalPage.ModalPage
import com.cid.ads.modalPage.rememberPageState
import com.cid.ads.modalPage.util.DragAnchor
import com.cid.ads.text.Text

/**
 * A color picker dialog is useful for selecting and customizing colors, providing users with
 * a convenient interface to choose from a wide range of color options. It offers a straightforward
 * and intuitive method for color selection, making it an effective tool for enhancing design
 * and user experience.
 *
 * @param state The state of the color picker, which contains information about the selected color
 * and other configurations.
 * @param title Title that will be display at top of the picker
 * @param colors The colors used for the color picker and the modal page.
 * @param onDismissRequest A callback function that is invoked when the user requests to dismiss
 * the dialog.
 */
@Composable
fun ColorPicker(
    state: ColorPickerState,
    title: String = stringResource(R.string.select_color),
    colors: ColorPickerColors = ColorPickerDefaults.colors(),
    onDismissRequest: () -> Unit
) {
    val widthSizeClass = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    val heightSizeClass = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    val maxModifier =
        if (widthSizeClass != WindowWidthSizeClass.COMPACT && heightSizeClass != WindowHeightSizeClass.COMPACT)
            Modifier.widthIn(max = 400.dp) else Modifier

    val insets =
        if (heightSizeClass == WindowHeightSizeClass.COMPACT)
            WindowInsets.safeContent.only(WindowInsetsSides.Horizontal)
        else WindowInsets(0, 0, 0, 0)

    ModalPage(
        pageState = rememberPageState(dragAnchors = setOf(DragAnchor.Fraction(0.7f))),
        contentWindowInsets = insets,
        onDismissRequest = onDismissRequest,
    ) {
        Column {
            Text(
                modifier = maxModifier
                    .fillMaxWidth()
                    .padding(top = AkaTheme.spacing.size20)
                    .padding(bottom = AkaTheme.spacing.size12),
                text = title,
                textAlign = TextAlign.Center,
                style = AkaTheme.typography.titleMedium,
                color = colors.titleColors
            )
            ColorPickerView(
                modifier = maxModifier.padding(bottom = AkaTheme.spacing.size16),
                state = state,
                colors = colors.colorPickerViewColors
            )
        }
    }
}