package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold

object ColorScheme : Screen {
    override val name: String = "Color scheme"
    override val image: Int = R.drawable.color_scheme
    override val navigation: String = "color_scheme"

    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() },
            topAppBarScrollBehavior = topAppBarScrollBehavior
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.primary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Primary",
                        color = AkaTheme.colorScheme.onPrimary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onPrimary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Primary",
                        color = AkaTheme.colorScheme.primary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.primaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Primary Container",
                        color = AkaTheme.colorScheme.onPrimaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onPrimaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Primary Container",
                        color = AkaTheme.colorScheme.primaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.secondary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Secondary",
                        color = AkaTheme.colorScheme.onSecondary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onSecondary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Secondary",
                        color = AkaTheme.colorScheme.secondary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.secondaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Secondary Container",
                        color = AkaTheme.colorScheme.onSecondaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onSecondaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Secondary Container",
                        color = AkaTheme.colorScheme.secondaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.tertiary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Tertiary",
                        color = AkaTheme.colorScheme.onTertiary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onTertiary)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Tertiary",
                        color = AkaTheme.colorScheme.tertiary,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.tertiaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Tertiary Container",
                        color = AkaTheme.colorScheme.onTertiaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onTertiaryContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Tertiary Container",
                        color = AkaTheme.colorScheme.tertiaryContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.error)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Error",
                        color = AkaTheme.colorScheme.onError,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onError)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Error",
                        color = AkaTheme.colorScheme.error,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.errorContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Error Container",
                        color = AkaTheme.colorScheme.onErrorContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onErrorContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Error Container",
                        color = AkaTheme.colorScheme.errorContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.warning)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Warning",
                        color = AkaTheme.colorScheme.onWarning,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onWarning)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Warning",
                        color = AkaTheme.colorScheme.warning,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.warningContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Warning Container",
                        color = AkaTheme.colorScheme.onWarningContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onWarningContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Warning Container",
                        color = AkaTheme.colorScheme.warningContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.valid)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Valid",
                        color = AkaTheme.colorScheme.onValid,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onValid)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Valid",
                        color = AkaTheme.colorScheme.valid,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.validContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Valid Container",
                        color = AkaTheme.colorScheme.onValidContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onValidContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Valid Container",
                        color = AkaTheme.colorScheme.validContainer,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.outline)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Outline",
                        color = AkaTheme.colorScheme.outlineVariant,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.outlineVariant)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Outline",
                        color = AkaTheme.colorScheme.outline,
                        style = AkaTheme.typography.headlineSmall
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surface)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.onSurface)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "On Surface",
                        color = AkaTheme.colorScheme.surface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceDim)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Dim",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceBright)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Bright",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceContainerLowest)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Container Lowest",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceContainerLow)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Container Low",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceContainer)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Container",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceContainerHigh)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Container High",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(AkaTheme.colorScheme.surfaceContainerHighest)
                        .padding(AkaTheme.spacing.size16),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = "Surface Container Highest",
                        color = AkaTheme.colorScheme.onSurface,
                        style = AkaTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}