package com.cid.ads.foundation

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import com.cid.ads.button.Button

val Neutral50 = Color(0xFFF7F7F7)
val Neutral100 = Color(0xFFEDEDED)
val Neutral200 = Color(0xFFDFDFDF)
val Neutral300 = Color(0xFFC8C8C8)
val Neutral400 = Color(0xFFADADAD)
val Neutral500 = Color(0xFF9E9E9E)
val Neutral600 = Color(0xFF888888)
val Neutral700 = Color(0xFF7B7B7B)
val Neutral800 = Color(0xFF676767)
val Neutral900 = Color(0xFF545454)
val Neutral950 = Color(0xFF363636)

// Primary Colors
val Primary50 = Color(0xFFFFF4ED)
val Primary100 = Color(0xFFFFE6D4)
val Primary200 = Color(0xFFFFC8A8)
val Primary300 = Color(0xFFFFA270)
val Primary400 = Color(0xFFFF6F37)
val Primary500 = Color(0xFFFF5722)
val Primary600 = Color(0xFFF02E06)
val Primary700 = Color(0xFFC71E07)
val Primary800 = Color(0xFF9E1A0E)
val Primary900 = Color(0xFF7F190F)
val Primary950 = Color(0xFF450805)


// Success Colors
val Green50 = Color(0xFFF3FAF3)
val Green100 = Color(0xFFE3F5E3)
val Green200 = Color(0xFFC8EAC9)
val Green300 = Color(0xFF9DD89F)
val Green400 = Color(0xFF6BBD6E)
val Green500 = Color(0xFF4CAF50)
val Green600 = Color(0xFF358438)
val Green700 = Color(0xFF2D6830)
val Green800 = Color(0xFF275429)
val Green900 = Color(0xFF224525)
val Green950 = Color(0xFF0E2510)

// Error Colors
val Red50 = Color(0xFFFEF3F2)
val Red100 = Color(0xFFFFE3E1)
val Red200 = Color(0xFFFFCCC8)
val Red300 = Color(0xFFFFA8A2)
val Red400 = Color(0xFFFFA8A2)
val Red500 = Color(0xFFF44336)
val Red600 = Color(0xFFE22D20)
val Red700 = Color(0xFFBE2217)
val Red800 = Color(0xFF9D2017)
val Red900 = Color(0xFF82211A)
val Red950 = Color(0xFF470C08)

//Warning Colors
val Yellow50 = Color(0xFFFFFFEA)
val Yellow100 = Color(0xFFFFFBC5)
val Yellow200 = Color(0xFFFFF885)
val Yellow300 = Color(0xFFFFEE46)
val Yellow400 = Color(0xFFFFDF1B)
val Yellow500 = Color(0xFFFFC107)
val Yellow600 = Color(0xFFE29400)
val Yellow700 = Color(0xFFBB6902)
val Yellow800 = Color(0xFF985108)
val Yellow900 = Color(0xFF7C420B)
val Yellow950 = Color(0xFF482200)

// Secondary Colors
val Blue50 = Color(0xFFEFF9FF)
val Blue100 = Color(0xFFDEF2FF)
val Blue200 = Color(0xFFB7E7FF)
val Blue300 = Color(0xFF77D5FF)
val Blue400 = Color(0xFF2EC1FF)
val Blue500 = Color(0xFF03A9F4)
val Blue600 = Color(0xFF0087D1)
val Blue700 = Color(0xFF006BA9)
val Blue800 = Color(0xFF015B8B)
val Blue900 = Color(0xFF074B73)
val Blue950 = Color(0xFF05304C)


/**
 * Class representing a color scheme for a UI theme.
 *
 * This class encapsulates various colors used in a UI theme, including primary, secondary, tertiary,
 * surface, error, valid, warning, outline, and other related colors. Each color can be individually accessed
 * and modified.
 *
 * @property primary The primary color.
 * @property onPrimary The color to use on top of the primary color.
 * @property primaryContainer The container color for the primary color.
 * @property onPrimaryContainer The color to use on top of the primary container color.
 * @property secondary The secondary color.
 * @property onSecondary The color to use on top of the secondary color.
 * @property secondaryContainer The container color for the secondary color.
 * @property onSecondaryContainer The color to use on top of the secondary container color.
 * @property tertiary The tertiary color.
 * @property onTertiary The color to use on top of the tertiary color.
 * @property tertiaryContainer The container color for the tertiary color.
 * @property onTertiaryContainer The color to use on top of the tertiary container color.
 * @property error The error color.
 * @property onError The color to use on top of the error color.
 * @property errorContainer The container color for the error color.
 * @property onErrorContainer The color to use on top of the error container color.
 * @property valid The valid color.
 * @property onValid The color to use on top of the valid color.
 * @property validContainer The container color for the valid color.
 * @property onValidContainer The color to use on top of the valid container color.
 * @property warning The warning color.
 * @property onWarning The color to use on top of the warning color.
 * @property warningContainer The container color for the warning color.
 * @property onWarningContainer The color to use on top of the warning container color.
 * @property surface The surface color.
 * @property onSurface The color to use on top of the surface color.
 * @property onSurfaceVariant The variant color to use on top of the surface color.
 * @property outline The outline color.
 * @property outlineVariant The variant color for the outline.
 * @property scrim The scrim color.
 * @property surfaceDim The dim surface color.
 * @property surfaceBright The bright surface color.
 * @property surfaceContainerLowest The lowest surface container color.
 * @property surfaceContainerLow The low surface container color.
 * @property surfaceContainer The surface container color.
 * @property surfaceContainerHigh The high surface container color.
 * @property surfaceContainerHighest The highest surface container color.
 */
class ColorScheme(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    valid: Color,
    onValid: Color,
    validContainer: Color,
    onValidContainer: Color,
    warning: Color,
    onWarning: Color,
    warningContainer: Color,
    onWarningContainer: Color,
    surface: Color,
    onSurface: Color,
    onSurfaceVariant: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color,
    surfaceDim: Color,
    surfaceBright: Color,
    surfaceContainerLowest: Color,
    surfaceContainerLow: Color,
    surfaceContainer: Color,
    surfaceContainerHigh: Color,
    surfaceContainerHighest: Color
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    var primaryContainer by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        internal set
    var onPrimaryContainer by mutableStateOf(onPrimaryContainer, structuralEqualityPolicy())
        internal set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        internal set
    var secondaryContainer by mutableStateOf(secondaryContainer, structuralEqualityPolicy())
        internal set
    var onSecondaryContainer by mutableStateOf(onSecondaryContainer, structuralEqualityPolicy())
        internal set
    var tertiary by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set
    var onTertiary by mutableStateOf(onTertiary, structuralEqualityPolicy())
        internal set
    var tertiaryContainer by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        internal set
    var onTertiaryContainer by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var onError by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    var errorContainer by mutableStateOf(errorContainer, structuralEqualityPolicy())
        internal set
    var onErrorContainer by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        internal set
    var valid by mutableStateOf(valid, structuralEqualityPolicy())
        internal set
    var onValid by mutableStateOf(onValid, structuralEqualityPolicy())
        internal set
    var validContainer by mutableStateOf(validContainer, structuralEqualityPolicy())
        internal set
    var onValidContainer by mutableStateOf(onValidContainer, structuralEqualityPolicy())
        internal set
    var warning by mutableStateOf(warning, structuralEqualityPolicy())
        internal set
    var onWarning by mutableStateOf(onWarning, structuralEqualityPolicy())
        internal set
    var warningContainer by mutableStateOf(warningContainer, structuralEqualityPolicy())
        internal set
    var onWarningContainer by mutableStateOf(onWarningContainer, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set
    var outline by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    var outlineVariant by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        internal set
    var scrim by mutableStateOf(scrim, structuralEqualityPolicy())
        internal set
    var surfaceDim by mutableStateOf(surfaceDim, structuralEqualityPolicy())
        internal set
    var surfaceBright by mutableStateOf(surfaceBright, structuralEqualityPolicy())
        internal set
    var surfaceContainerLowest by mutableStateOf(surfaceContainerLowest, structuralEqualityPolicy())
        internal set
    var surfaceContainerLow by mutableStateOf(surfaceContainerLow, structuralEqualityPolicy())
        internal set
    var surfaceContainer by mutableStateOf(surfaceContainer, structuralEqualityPolicy())
        internal set
    var surfaceContainerHigh by mutableStateOf(surfaceContainerHigh, structuralEqualityPolicy())
        internal set
    var surfaceContainerHighest by mutableStateOf(
        surfaceContainerHighest,
        structuralEqualityPolicy()
    )
        internal set

    /** Returns a copy of this ColorScheme, optionally overriding some of the values. */
    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        valid: Color = this.valid,
        onValid: Color = this.onValid,
        validContainer: Color = this.validContainer,
        onValidContainer: Color = this.onValidContainer,
        warning: Color = this.warning,
        onWarning: Color = this.onWarning,
        warningContainer: Color = this.warningContainer,
        onWarningContainer: Color = this.onWarningContainer,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        scrim: Color = this.scrim,
        surfaceDim: Color = this.surfaceDim,
        surfaceBright: Color = this.surfaceBright,
        surfaceContainerLowest: Color = this.surfaceContainerLowest,
        surfaceContainerLow: Color = this.surfaceContainerLow,
        surfaceContainer: Color = this.surfaceContainer,
        surfaceContainerHigh: Color = this.surfaceContainerHigh,
        surfaceContainerHighest: Color = this.surfaceContainerHighest
    ): ColorScheme =
        ColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            valid = valid,
            onValid = onValid,
            validContainer = validContainer,
            onValidContainer = onValidContainer,
            warning = warning,
            onWarning = onWarning,
            warningContainer = warningContainer,
            onWarningContainer = onWarningContainer,
            surface = surface,
            onSurface = onSurface,
            onSurfaceVariant = onSurfaceVariant,
            outline = outline,
            outlineVariant = outlineVariant,
            scrim = scrim,
            surfaceDim = surfaceDim,
            surfaceBright = surfaceBright,
            surfaceContainerLowest = surfaceContainerLowest,
            surfaceContainerLow = surfaceContainerLow,
            surfaceContainer = surfaceContainer,
            surfaceContainerHigh = surfaceContainerHigh,
            surfaceContainerHighest = surfaceContainerHighest,
        )

    override fun toString(): String {
        return "ColorScheme(" +
                "\tprimary = $primary\n" +
                "\tonPrimary = $onPrimary\n" +
                "\tprimaryContainer = $primaryContainer\n" +
                "\tonPrimaryContainer = $onPrimaryContainer\n" +
                "\tsecondary = $secondary\n" +
                "\tonSecondary = $onSecondary\n" +
                "\tsecondaryContainer = $secondaryContainer\n" +
                "\tonSecondaryContainer = $onSecondaryContainer\n" +
                "\ttertiary = $tertiary\n" +
                "\tonTertiary = $onTertiary\n" +
                "\ttertiaryContainer = $tertiaryContainer\n" +
                "\tonTertiaryContainer = $onTertiaryContainer\n" +
                "\terror = $error\n" +
                "\tonError = $onError\n" +
                "\terrorContainer = $errorContainer\n" +
                "\tonErrorContainer = $onErrorContainer\n" +
                "\tvalid = $valid\n" +
                "\tonValid = $onValid\n" +
                "\tvalidContainer = $validContainer\n" +
                "\tonValidContainer = $onValidContainer\n" +
                "\twarning = $warning\n" +
                "\tonWarning = $onWarning\n" +
                "\twarningContainer = $warningContainer\n" +
                "\tonWarningContainer = $onWarningContainer\n" +
                "\tsurface = $surface\n" +
                "\tonSurface = $onSurface\n" +
                "\tsurfaceVariant = $onSurfaceVariant\n" +
                "\toutline = $outline\n" +
                "\toutlineVariant = $outlineVariant\n" +
                "\tscrim=$scrim\n" +
                "\tscrim=$surfaceDim\n" +
                "\tscrim=$surfaceBright\n" +
                "\tscrim=$surfaceContainerLowest\n" +
                "\tscrim=$surfaceContainerLow\n" +
                "\tscrim=$surfaceContainer\n" +
                "\tscrim=$surfaceContainerHigh\n" +
                "\tscrim=$surfaceContainerHighest\n" +
                ")"
    }
}

/**
 * Returns a light IDS color scheme.
 */
fun lightColorScheme(
    primary: Color = Primary500,
    onPrimary: Color = Color(0xFFFFFFFF),
    primaryContainer: Color = Primary100,
    onPrimaryContainer: Color = Primary900,
    secondary: Color = Blue500,
    onSecondary: Color = Color(0xFFFFFFFF),
    secondaryContainer: Color = Blue100,
    onSecondaryContainer: Color = Blue900,
    tertiary: Color = Green400,
    onTertiary: Color = Color(0xFFFFFFFF),
    tertiaryContainer: Color = Green100,
    onTertiaryContainer: Color = Green900,
    error: Color = Red500,
    onError: Color = Color(0xFFFFFFFF),
    errorContainer: Color = Red100,
    onErrorContainer: Color = Red900,
    valid: Color = Green600,
    onValid: Color = Color(0xFFFFFFFF),
    validContainer: Color =  Green100,
    onValidContainer: Color = Green900,
    warning: Color = Yellow600,
    onWarning: Color = Color(0xFFFFFFFF),
    warningContainer: Color = Yellow100,
    onWarningContainer: Color = Yellow900,
    surface: Color = Neutral50,
    onSurface: Color = Neutral900,
    onSurfaceVariant: Color = Neutral700,
    outline: Color = Neutral500,
    outlineVariant: Color = Neutral300,
    scrim: Color = Color(0xFF000000),
    surfaceDim: Color = Neutral200,
    surfaceBright: Color = Neutral50,
    surfaceContainerLowest: Color = Color(0xFFFFFFFF),
    surfaceContainerLow: Color = Neutral100,
    surfaceContainer: Color = Neutral200,
    surfaceContainerHigh: Color = Neutral300,
    surfaceContainerHighest: Color = Neutral400,
): ColorScheme =
    ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        valid = valid,
        onValid = onValid,
        validContainer = validContainer,
        onValidContainer = onValidContainer,
        warning = warning,
        onWarning = onWarning,
        warningContainer = warningContainer,
        onWarningContainer = onWarningContainer,
        surface = surface,
        onSurface = onSurface,
        onSurfaceVariant = onSurfaceVariant,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceDim = surfaceDim,
        surfaceBright = surfaceBright,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest
    )

/**
 * Returns a dark Material color scheme.
 */
fun darkColorScheme(
    primary: Color = Primary400,
    onPrimary: Color = Color.Black,
    primaryContainer: Color = Primary900,
    onPrimaryContainer: Color = Primary100,
    secondary: Color = Blue400,
    onSecondary: Color = Color.Black,
    secondaryContainer: Color = Blue900,
    onSecondaryContainer: Color = Blue100,
    tertiary: Color = Green400,
    onTertiary: Color = Color.Black,
    tertiaryContainer: Color = Green900,
    onTertiaryContainer: Color = Green100,
    error: Color = Red400,
    onError: Color = Color.Black,
    errorContainer: Color = Red900,
    onErrorContainer: Color = Red100,
    valid: Color = Green500,
    onValid: Color = Color.Black,
    validContainer: Color = Green900,
    onValidContainer: Color = Green100,
    warning: Color = Yellow500,
    onWarning: Color = Color.Black,
    warningContainer: Color = Yellow900,
    onWarningContainer: Color = Yellow100,
    surface: Color = Neutral950,
    onSurface: Color = Neutral100,
    onSurfaceVariant: Color = Neutral300,
    outline: Color = Neutral600,
    outlineVariant: Color = Neutral800,
    scrim: Color = Color(0xFF000000),
    surfaceDim: Color = Neutral900,
    surfaceBright: Color = Neutral800,
    surfaceContainerLowest: Color = Neutral950,
    surfaceContainerLow: Color = Neutral900,
    surfaceContainer: Color = Neutral800,
    surfaceContainerHigh: Color = Neutral700,
    surfaceContainerHighest: Color = Neutral600,
): ColorScheme =
    ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        valid = valid,
        onValid = onValid,
        validContainer = validContainer,
        onValidContainer = onValidContainer,
        warning = warning,
        onWarning = onWarning,
        warningContainer = warningContainer,
        onWarningContainer = onWarningContainer,
        surface = surface,
        onSurface = onSurface,
        onSurfaceVariant = onSurfaceVariant,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        surfaceDim = surfaceDim,
        surfaceBright = surfaceBright,
        surfaceContainerLowest = surfaceContainerLowest,
        surfaceContainerLow = surfaceContainerLow,
        surfaceContainer = surfaceContainer,
        surfaceContainerHigh = surfaceContainerHigh,
        surfaceContainerHighest = surfaceContainerHighest
    )

val LightColorScheme = lightColorScheme()

val DarkColorScheme = darkColorScheme()

val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }

/**
 * Composable function to remember and create an instance of [TextSelectionColors] based on the provided [ColorScheme].
 *
 * This function uses the primary color from the [ColorScheme] to determine the handle and background colors
 * for text selection. The background color is derived from the primary color with an alpha value of 0.4.
 *
 * @param colorScheme The [ColorScheme] from which to derive the text selection colors.
 * @return An instance of [TextSelectionColors] with the specified handle and background colors.
 */
@Composable
internal fun rememberTextSelectionColors(colorScheme: ColorScheme): TextSelectionColors {
    val primaryColor = colorScheme.primary
    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = 0.4f),
        )
    }
}

/**
 * The IDS color system contains pairs of colors that are typically used for the background and
 * content color inside a component. For example, a primary [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [ColorScheme], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [ColorScheme.primary], this will return [ColorScheme.onPrimary].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * [Color.Unspecified].
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [ColorScheme], then returns [Color.Unspecified].
 *
 * @see contentColorFor
 */
@Stable
fun ColorScheme.contentColorFor(backgroundColor: Color): Color =
    when (backgroundColor) {
        primary -> onPrimary
        secondary -> onSecondary
        tertiary -> onTertiary
        error -> onError
        valid -> onValid
        primaryContainer -> onPrimaryContainer
        secondaryContainer -> onSecondaryContainer
        tertiaryContainer -> onTertiaryContainer
        errorContainer -> onErrorContainer
        validContainer -> onValidContainer
        warning -> onWarning
        warningContainer -> onWarningContainer
        surface -> onSurface
        surfaceDim -> onSurface
        surfaceBright -> onSurface
        surfaceContainerLowest -> onSurface
        surfaceContainerLow -> onSurface
        surfaceContainer -> onSurface
        surfaceContainerHigh -> onSurface
        surfaceContainerHighest -> onSurface
        else -> Color.Unspecified
    }

/**
 * The IDS color system contains pairs of colors that are typically used for the background and
 * content color inside a component. For example, a primary [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [ColorScheme], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [ColorScheme.primary], this will return [ColorScheme.onPrimary].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return the current
 * value of [LocalContentColor] as a best-effort color.
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [ColorScheme], then returns the current value of [LocalContentColor].
 *
 * @see ColorScheme.contentColorFor
 */
@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    AkaTheme.colorScheme.contentColorFor(backgroundColor)
        .takeOrElse { LocalContentColor.current }


/**
 * CompositionLocal containing the preferred content color for a given position in the hierarchy.
 * This typically represents the `on` color for a color in [ColorScheme]. For example, if the
 * background color is [ColorScheme.surface], this color is typically set to
 * [ColorScheme.onSurface].
 *
 * This color should be used for any typography / iconography, to ensure that the color of these
 * adjusts when the background color changes. For example, on a dark background, text should be
 * light, and on a light background, text should be dark.
 *
 * Defaults to [Color.Black] if no color has been explicitly set.
 */
val LocalContentColor = compositionLocalOf { Color.Black }