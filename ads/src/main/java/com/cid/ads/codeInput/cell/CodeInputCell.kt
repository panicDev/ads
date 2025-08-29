package com.cid.ads.codeInput.cell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cid.ads.codeInput.CellColors
import com.cid.ads.codeInput.FourDigitCodeInput
import com.cid.ads.codeInput.SixDigitCodeInput
import com.cid.ads.foundation.IdsState38
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.internal.SecureInputSettings
import com.cid.ads.text.Text

/**
 * Create a cell that used by [SixDigitCodeInput] and [FourDigitCodeInput]
 *
 * @param modifier The [Modifier] to be applied to this composable.
 * @param value The cell value.
 * @param enabled Whether the cell is enabled or disabled.
 * @param isValid Whether the cell's value is valid.
 * @param isError Whether the cell's value is in error state.
 * @param isFocused Whether the cell's value is focused.
 * @param secure Whether the cell should mask its input as a password.
 * @param colors The colors to be used for the cell.
 * @param textStyle The [TextStyle] to be applied to the text in the cell.
 */
@Composable
internal fun CodeInputCell(
    modifier: Modifier = Modifier,
    value: String,
    enabled: Boolean,
    isValid: Boolean,
    isError: Boolean,
    isFocused: Boolean,
    secure: SecureInputSettings,
    colors: CellColors,
    textStyle: TextStyle,
) {

    val textColor = colors.textColor(enabled, isValid, isError, isFocused).value

    val mergedTextStyle = textStyle.merge(
        TextStyle(
            color = textColor,
            baselineShift = BaselineShift.None,
            textAlign = TextAlign.Center
        )
    )

    val borderThickness = if (enabled && (isFocused || isError || isValid)) 2.dp else 1.dp

    val containerColor = colors.containerColor(
        enabled = enabled,
        isValid = isValid,
        isError = isError,
        isFocused = isFocused
    ).value

    val borderColor = colors.indicatorColor(
        enabled = enabled,
        isValid = isValid,
        isError = isError,
        isFocused = isFocused
    ).value

    Box(
        modifier = Modifier
            .graphicsLayer {
                alpha = if (enabled) 1f
                else IdsState38
            }
            .width(48.dp)
            .height(52.dp)
            .border(
                borderThickness,
                borderColor,
                AkaTheme.shapes.shape16
            )
            .background(
                containerColor,
                AkaTheme.shapes.shape16
            )
            .clip(AkaTheme.shapes.shape16)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            style = mergedTextStyle,
            color = textColor
        )
    }
}