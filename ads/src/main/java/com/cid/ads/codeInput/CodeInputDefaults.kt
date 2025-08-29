package com.cid.ads.codeInput

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.cid.ads.codeInput.cell.CodeInputCell
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.foundation.state08
import com.cid.ads.foundation.state12
import com.cid.ads.foundation.state16

/**
 * Contains the default values used by [SixDigitCodeInput] and [FourDigitCodeInput].
 */
object CodeInputDefaults {

    /**
     * Create a [CellColors] that represents the default container and content colors used in a
     * [CodeInputCell].
     *
     * @param defaultTextColor The default text color.
     * @param hoveredTextColor The text color when the cell is hovered.
     * @param focusedTextColor The text color when the cell is focused.
     * @param validTextColor The text color when the cell's value is valid.
     * @param errorTextColor The text color when the cell's value is in error state.
     * @param defaultContainerColor The default container color.
     * @param hoveredContainerColor The container color when the cell is hovered.
     * @param focusedContainerColor The container color when the cell is focused.
     * @param validContainerColor The container color when the cell's value is valid.
     * @param errorContainerColor The container color when the cell's value is in error state.
     * @param defaultCursorColor The default cursor color.
     * @param validCursorColor The cursor color when the cell's value is valid.
     * @param errorCursorColor The cursor color when the cell's value is in error state.
     * @param textSelectionColors The colors for text selection.
     * @param defaultIndicatorColor The default indicator color.
     * @param hoveredIndicatorColor The indicator color when the cell is hovered.
     * @param focusedIndicatorColor The indicator color when the cell is focused.
     * @param validIndicatorColor The indicator color when the cell's value is valid.
     * @param errorIndicatorColor The indicator color when the cell's value is in error state.
     */
    @Composable
    fun cellColors(
        //Text Colors
        defaultTextColor: Color = AkaTheme.colorScheme.onSurface,
        hoveredTextColor: Color = AkaTheme.colorScheme.onSurface,
        focusedTextColor: Color = AkaTheme.colorScheme.onSurface,
        validTextColor: Color = AkaTheme.colorScheme.valid,
        errorTextColor: Color = AkaTheme.colorScheme.error,

        //Container Colors
        defaultContainerColor: Color = AkaTheme.colorScheme.primaryContainer.state08,
        hoveredContainerColor: Color = AkaTheme.colorScheme.primaryContainer.state12,
        focusedContainerColor: Color = AkaTheme.colorScheme.primaryContainer.state16,
        validContainerColor: Color = AkaTheme.colorScheme.validContainer.state12,
        errorContainerColor: Color = AkaTheme.colorScheme.errorContainer.state12,

        //Cursor Colors
        defaultCursorColor: Color = AkaTheme.colorScheme.primary,
        validCursorColor: Color = AkaTheme.colorScheme.valid,
        errorCursorColor: Color = AkaTheme.colorScheme.error,
        textSelectionColors: TextSelectionColors = TextSelectionColors(
            handleColor = AkaTheme.colorScheme.primary,
            backgroundColor = AkaTheme.colorScheme.primary.copy(alpha = 0.4f)
        ),

        //Indicator Colors
        defaultIndicatorColor: Color = AkaTheme.colorScheme.outlineVariant,
        hoveredIndicatorColor: Color = AkaTheme.colorScheme.outline,
        focusedIndicatorColor: Color = AkaTheme.colorScheme.primary,
        validIndicatorColor: Color = AkaTheme.colorScheme.valid,
        errorIndicatorColor: Color = AkaTheme.colorScheme.error,
    ) = CellColors(
        //Text Colors
        defaultTextColor = defaultTextColor,
        hoveredTextColor = hoveredTextColor,
        focusedTextColor = focusedTextColor,
        validTextColor = validTextColor,
        errorTextColor = errorTextColor,

        //Container Colors
        defaultContainerColor = defaultContainerColor,
        hoveredContainerColor = hoveredContainerColor,
        focusedContainerColor = focusedContainerColor,
        validContainerColor = validContainerColor,
        errorContainerColor = errorContainerColor,

        //Indicator Colors
        defaultIndicatorColor = defaultIndicatorColor,
        hoveredIndicatorColor = hoveredIndicatorColor,
        focusedIndicatorColor = focusedIndicatorColor,
        validIndicatorColor = validIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
    )

}

/**
 * Represents the container and content colors used in a code input in different states.
 *
 * @param defaultTextColor The default text color.
 * @param hoveredTextColor The text color when the cell is hovered.
 * @param focusedTextColor The text color when the cell is focused.
 * @param validTextColor The text color when the cell's value is valid.
 * @param errorTextColor The text color when the cell's value is in error state.
 *
 * @param defaultContainerColor The default container color.
 * @param hoveredContainerColor The container color when the cell is hovered.
 * @param focusedContainerColor The container color when the cell is focused.
 * @param validContainerColor The container color when the cell's value is valid.
 * @param errorContainerColor The container color when the cell's value is in error state.
 *
 * @param defaultIndicatorColor The default indicator color.
 * @param hoveredIndicatorColor The indicator color when the cell is hovered.
 * @param focusedIndicatorColor The indicator color when the cell is focused.
 * @param validIndicatorColor The indicator color when the cell's value is valid.
 * @param errorIndicatorColor The indicator color when the cell's value is in error state.
 */
@Immutable
class CellColors(

    //Text Colors
    private val defaultTextColor: Color,
    private val hoveredTextColor: Color,
    private val focusedTextColor: Color,
    private val validTextColor: Color,
    private val errorTextColor: Color,

    //Container Colors
    private val defaultContainerColor: Color,
    private val hoveredContainerColor: Color,
    private val focusedContainerColor: Color,
    private val validContainerColor: Color,
    private val errorContainerColor: Color,

    //Indicator Colors
    private val defaultIndicatorColor: Color,
    private val hoveredIndicatorColor: Color,
    private val focusedIndicatorColor: Color,
    private val validIndicatorColor: Color,
    private val errorIndicatorColor: Color,
) {

    /**
     * Returns the appropriate text color based on the cell's state.
     *
     * @param isValid Whether the cell's value is valid.
     * @param isError Whether the cell's value is in error state.
     */
    @Composable
    internal fun textColor(
        enabled: Boolean,
        isValid: Boolean,
        isError: Boolean,
        isFocused: Boolean
    ): State<Color> {
        val targetValue = when {
            !enabled -> defaultTextColor
            isError -> errorTextColor
            isValid -> validTextColor
            isFocused -> focusedTextColor

            else -> defaultTextColor
        }
        return rememberUpdatedState(targetValue)
    }

    /**
     * Returns the appropriate container color based on the cell's state.
     *
     * @param isValid Whether the cell's value is valid.
     * @param isError Whether the cell's value is in error state.
     */
    @Composable
    internal fun containerColor(
        enabled: Boolean,
        isValid: Boolean,
        isError: Boolean,
        isFocused: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> defaultContainerColor
            isError -> errorContainerColor
            isValid -> validContainerColor
            isFocused -> focusedContainerColor
            else -> defaultContainerColor
        }
        return rememberUpdatedState(targetValue)
    }

    /**
     * Returns the appropriate indicator color based on the cell's state.
     *
     * @param isValid Whether the cell's value is valid.
     * @param isError Whether the cell's value is in error state.
     */
    @Composable
    internal fun indicatorColor(
        enabled: Boolean,
        isValid: Boolean,
        isError: Boolean,
        isFocused: Boolean
    ): State<Color> {

        val targetValue = when {
            !enabled -> defaultIndicatorColor
            isError -> errorIndicatorColor
            isValid -> validIndicatorColor
            isFocused -> focusedIndicatorColor
            else -> defaultIndicatorColor
        }
        return if (enabled) {
            animateColorAsState(
                targetValue, tween(durationMillis = ANIMATION_DURATION),
                label = "Indicator Color Animation"
            )
        } else {
            rememberUpdatedState(targetValue)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is CellColors) return false

        //Text Colors
        if (defaultTextColor != other.defaultTextColor) return false
        if (hoveredTextColor != other.hoveredTextColor) return false
        if (focusedTextColor != other.focusedTextColor) return false
        if (validTextColor != other.validTextColor) return false
        if (errorTextColor != other.errorTextColor) return false

        //Container Colors
        if (defaultContainerColor != other.defaultContainerColor) return false
        if (hoveredContainerColor != other.hoveredContainerColor) return false
        if (focusedContainerColor != other.focusedContainerColor) return false
        if (errorContainerColor != other.errorContainerColor) return false
        if (validContainerColor != other.validContainerColor) return false

        //Indicator Colors
        if (defaultIndicatorColor != other.defaultIndicatorColor) return false
        if (focusedIndicatorColor != other.focusedIndicatorColor) return false
        if (hoveredIndicatorColor != other.hoveredIndicatorColor) return false
        if (validIndicatorColor != other.validIndicatorColor) return false
        return errorIndicatorColor == other.errorIndicatorColor
    }

    override fun hashCode(): Int {
        //Text Colors
        var result = defaultTextColor.hashCode()
        result = 31 * result + hoveredTextColor.hashCode()
        result = 31 * result + focusedTextColor.hashCode()
        result = 31 * result + errorTextColor.hashCode()
        result = 31 * result + validTextColor.hashCode()

        //Container Colors
        result = 31 * result + defaultContainerColor.hashCode()
        result = 31 * result + hoveredContainerColor.hashCode()
        result = 31 * result + focusedContainerColor.hashCode()
        result = 31 * result + errorContainerColor.hashCode()
        result = 31 * result + validContainerColor.hashCode()

        //Indicator Colors
        result = 31 * result + defaultIndicatorColor.hashCode()
        result = 31 * result + hoveredIndicatorColor.hashCode()
        result = 31 * result + focusedIndicatorColor.hashCode()
        result = 31 * result + errorIndicatorColor.hashCode()
        result = 31 * result + validIndicatorColor.hashCode()
        return result
    }

    private companion object {
        const val ANIMATION_DURATION = 150
    }
}