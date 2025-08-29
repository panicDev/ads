package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.surface.Surface
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Elevation : Screen {
    override val name: String = "Elevation"
    override val image: Int = R.drawable.elevation
    override val navigation: String = "elevation"

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
                verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size12)
            ) {
                SampleRow(text = "1", firstItem = true) {
                    Surface(
                        modifier = Modifier.size(200.dp),
                        shape = AkaTheme.shapes.shape24,
                        color = AkaTheme.colorScheme.surfaceContainerHighest,
                        shadowElevation = AkaTheme.elevation.elevation1
                    ) {}
                }
                SampleRow(text = "2") {
                    Surface(
                        modifier = Modifier.size(200.dp),
                        shape = AkaTheme.shapes.shape24,
                        color = AkaTheme.colorScheme.surfaceContainerHighest,
                        shadowElevation = AkaTheme.elevation.elevation2
                    ) {}
                }
                SampleRow(text = "3") {
                    Surface(
                        modifier = Modifier.size(200.dp),
                        shape = AkaTheme.shapes.shape24,
                        color = AkaTheme.colorScheme.surfaceContainerHighest,
                        shadowElevation = AkaTheme.elevation.elevation3
                    ) {}
                }
                SampleRow(text = "4") {
                    Surface(
                        modifier = Modifier.size(200.dp),
                        shape = AkaTheme.shapes.shape24,
                        color = AkaTheme.colorScheme.surfaceContainerHighest,
                        shadowElevation = AkaTheme.elevation.elevation4
                    ) {}
                }
                SampleRow(text = "5", lastItem = true) {
                    Surface(
                        modifier = Modifier.size(200.dp),
                        shape = AkaTheme.shapes.shape24,
                        color = AkaTheme.colorScheme.surfaceContainerHighest,
                        shadowElevation = AkaTheme.elevation.elevation5
                    ) {}
                }
            }
        }
    }
}