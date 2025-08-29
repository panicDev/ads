package com.cid.ads.foundation

import androidx.compose.ui.graphics.Color

/**
 * A constant representing a view state value of 0.08f.
 */
internal const val IdsState08 = 0.08f

/**
 * A constant representing a view state value of 0.12f.
 */
internal const val IdsState12 = 0.12f

/**
 * A constant representing a view state value of 0.16f.
 */
internal const val IdsState16 = 0.16f

/**
 * A constant representing a view state value of 0.38f.
 */
internal const val IdsState38 = 0.38f

/**
 * An extension property for [Color] that returns a new [Color] with the alpha value set to [IdsState08].
 */
val Color.state08
    get() = this.copy(IdsState08)

/**
 * An extension property for [Color] that returns a new [Color] with the alpha value set to [IdsState12].
 */
val Color.state12
    get() = this.copy(IdsState12)

/**
 * An extension property for [Color] that returns a new [Color] with the alpha value set to [IdsState16].
 */
val Color.state16
    get() = this.copy(IdsState16)

/**
 * An extension property for [Color] that returns a new [Color] with the alpha value set to [IdsState38].
 */
val Color.state38
    get() = this.copy(IdsState38)