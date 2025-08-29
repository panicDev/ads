package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold

object Typography : Screen {
    override val name: String = "Typography"
    override val image: Int = R.drawable.typography
    override val navigation: String = "typography"

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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size12)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Display Large - Inter Regular 57/64 -0.25",
                        style = AkaTheme.typography.displayLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Display Medium - Inter Regular 45/52 -0.25",
                        style = AkaTheme.typography.displayMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Display Small - Inter Regular 36/44 -0.25",
                        style = AkaTheme.typography.displaySmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Headline Large - Inter Regular 32/40 . 0",
                        style = AkaTheme.typography.headlineLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Headline Medium - Inter Regular 28/36 . 0",
                        style = AkaTheme.typography.headlineMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Headline Small - Inter Regular 24/32 . 0",
                        style = AkaTheme.typography.headlineSmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Title Large - Inter Medium 22/28 . +0.05",
                        style = AkaTheme.typography.titleLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Title Medium - Inter Medium 16/24 . +0.05",
                        style = AkaTheme.typography.titleMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Title Small - Inter Medium 14/20 . +0.05",
                        style = AkaTheme.typography.titleSmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Label Large - Inter Medium 16/24 +0.2",
                        style = AkaTheme.typography.labelLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Label Medium - Inter Medium 14/20 +0.2",
                        style = AkaTheme.typography.labelMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Label Small - Inter Semibold 12/16 +0.2",
                        style = AkaTheme.typography.labelSmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Label Extra Small - Inter Medium 11/14 +0.2",
                        style = AkaTheme.typography.labelExtraSmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Button Large - Inter Extra Black 16/24 +0.5",
                        style = AkaTheme.typography.buttonLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Button Medium - Inter Extra Black 14/20 +0.5",
                        style = AkaTheme.typography.buttonMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Button Small - Inter Extra Black 12/16 +0.5",
                        style = AkaTheme.typography.buttonSmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size24)
                ) {
                    Text(
                        text = "Body Large - Inter Regular 16/24 . +0.35",
                        style = AkaTheme.typography.bodyLarge,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Body Medium - Inter Regular 14/20 . +0.25",
                        style = AkaTheme.typography.bodyMedium,
                        color = AkaTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Body Small - Inter Regular 12/16 . +0.1 ",
                        style = AkaTheme.typography.bodySmall,
                        color = AkaTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}