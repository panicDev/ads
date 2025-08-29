package com.cid.ads.foundation.ripple

import androidx.compose.material.ripple.RippleAlpha
import com.cid.ads.foundation.IdsState08
import com.cid.ads.foundation.IdsState12
import com.cid.ads.foundation.IdsState16


/**
 * Default values used by [ripple].
 */
object RippleDefaults {
    /**
     * Represents the default [RippleAlpha] that will be used for a ripple to indicate different
     * states.
     */
    val RippleAlpha: RippleAlpha =
        RippleAlpha(
            hoveredAlpha = IdsState08,
            focusedAlpha = IdsState12,
            pressedAlpha = IdsState16,
            draggedAlpha = IdsState16,
        )
}