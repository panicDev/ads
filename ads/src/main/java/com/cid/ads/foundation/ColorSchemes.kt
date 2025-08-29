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

val Neutral50 = Color(0xFFFAFAFA)
val Neutral100 = Color(0xFFF5F5F5)
val Neutral200 = Color(0xFFEEEEEE)
val Neutral300 = Color(0xFFE0E0E0)
val Neutral400 = Color(0xFFBDBDBD)
val Neutral500 = Color(0xFF9E9E9E)
val Neutral600 = Color(0xFF757575)
val Neutral700 = Color(0xFF616161)
val Neutral800 = Color(0xFF424242)
val Neutral900 = Color(0xFF212121)

// Primary Colors
val Primary100 = Color(0xFFE1F4FE) // paling terang
val Primary200 = Color(0xFFB8E5FD)
val Primary300 = Color(0xFF8DD3FB)
val Primary400 = Color(0xFF6FC4FA)
val Primary500 = Color(0xFF61BBF9) // warna dasar
val Primary600 = Color(0xFF4BA2E0)
val Primary700 = Color(0xFF3B83B8)
val Primary800 = Color(0xFF2B648E)
val Primary900 = Color(0xFF1B4565) // paling gelap

val Danger100 = Color(0xFFFDECEC)
val Danger200 = Color(0xFFFABEBE)
val Danger300 = Color(0xFFF79090)
val Danger400 = Color(0xFFF56D6D)
val Danger500 = Color(0xFFF75555) // base
val Danger600 = Color(0xFFD84343)
val Danger700 = Color(0xFFB23535)
val Danger800 = Color(0xFF8C2727)
val Danger900 = Color(0xFF661A1A)


val Success100 = Color(0xFFE8F5E9)
val Success200 = Color(0xFFC8E6C9)
val Success300 = Color(0xFFA5D6A7)
val Success400 = Color(0xFF81C784)
val Success500 = Color(0xFF4CAF50) // base
val Success600 = Color(0xFF43A047)
val Success700 = Color(0xFF388E3C)
val Success800 = Color(0xFF2E7D32)
val Success900 = Color(0xFF1B5E20)

val Warning100 = Color(0xFFFFF3E0)
val Warning200 = Color(0xFFFFE0B2)
val Warning300 = Color(0xFFFFCC80)
val Warning400 = Color(0xFFFFB74D)
val Warning500 = Color(0xFFFF9800) // base
val Warning600 = Color(0xFFFB8C00)
val Warning700 = Color(0xFFF57C00)
val Warning800 = Color(0xFFEF6C00)
val Warning900 = Color(0xFFE65100)

val Info100 = Color(0xFFE3F2FD)
val Info200 = Color(0xFFBBDEFB)
val Info300 = Color(0xFF90CAF9)
val Info400 = Color(0xFF64B5F6)
val Info500 = Color(0xFF2196F3) // base
val Info600 = Color(0xFF1E88E5)
val Info700 = Color(0xFF1976D2)
val Info800 = Color(0xFF1565C0)
val Info900 = Color(0xFF0D47A1)

val BgBodyMain = Color(0xFFF9FAFC)
val BgBody1 = Color(0xFFF8FAFF)
val BgBody2 = Color(0xFFEDEFF6)
val BgBody3 = Color(0xFFE2E4EC)
val BgLight = Color(0xFFFBFBFB)





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
    secondary: Color = Primary500,
    onSecondary: Color = Color(0xFFFFFFFF),
    secondaryContainer: Color = Primary100,
    onSecondaryContainer: Color = Primary900,
    tertiary: Color = Success400,
    onTertiary: Color = Color(0xFFFFFFFF),
    tertiaryContainer: Color = Success100,
    onTertiaryContainer: Color = Success900,
    error: Color = Danger500,
    onError: Color = Color(0xFFFFFFFF),
    errorContainer: Color = Danger100,
    onErrorContainer: Color = Danger900,
    valid: Color = Success500,
    onValid: Color = Color(0xFFFFFFFF),
    validContainer: Color =  Success100,
    onValidContainer: Color = Success900,
    warning: Color = Warning500,
    onWarning: Color = Color(0xFFFFFFFF),
    warningContainer: Color = Warning100,
    onWarningContainer: Color = Warning900,
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
    secondary: Color = Primary400,
    onSecondary: Color = Color.Black,
    secondaryContainer: Color = Primary900,
    onSecondaryContainer: Color = Primary100,
    tertiary: Color = Success400,
    onTertiary: Color = Color.Black,
    tertiaryContainer: Color = Success900,
    onTertiaryContainer: Color = Success100,
    error: Color = Danger400,
    onError: Color = Color.Black,
    errorContainer: Color = Danger900,
    onErrorContainer: Color = Danger100,
    valid: Color = Success500,
    onValid: Color = Color.Black,
    validContainer: Color = Success900,
    onValidContainer: Color = Success100,
    warning: Color = Warning500,
    onWarning: Color = Color.Black,
    warningContainer: Color = Warning900,
    onWarningContainer: Color = Warning100,
    surface: Color = Neutral900,
    onSurface: Color = Neutral100,
    onSurfaceVariant: Color = Neutral300,
    outline: Color = Neutral600,
    outlineVariant: Color = Neutral800,
    scrim: Color = Color(0xFF000000),
    surfaceDim: Color = Neutral900,
    surfaceBright: Color = Neutral800,
    surfaceContainerLowest: Color = Neutral900,
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