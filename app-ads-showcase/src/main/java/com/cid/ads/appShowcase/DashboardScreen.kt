package com.cid.ads.appShowcase

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.surface.Surface
import com.cid.ads.text.Text
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.componets.SampleScaffold
import com.cid.ads.appShowcase.screens.Screen

@Composable
fun DashboardScreen(
    navController: NavHostController,
    foundationScreens: List<Screen>,
    componentScreens: List<Screen>
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    SampleScaffold(
        title = "IDS Catalog",
        topAppBarScrollBehavior = topAppBarScrollBehavior
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = AkaTheme.spacing.size16)
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
            contentPadding = padding,
            columns = GridCells.Adaptive(180.dp),
            verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size16),
            horizontalArrangement = Arrangement.spacedBy(
                AkaTheme.spacing.size16,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Foundation",
                    style = AkaTheme.typography.headlineSmall
                )
            }
            items(foundationScreens, key = { it.name }, contentType = { it }) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .heightIn(min = 272.dp),
                    shape = AkaTheme.shapes.shape20,
                    border = BorderStroke(
                        width = 1.dp,
                        color = AkaTheme.colorScheme.outline
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate(it.navigation)
                            }
                            .padding(AkaTheme.spacing.size12),
                        verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size8)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(AkaTheme.shapes.shape10)
                                .clipToBounds()
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .toolingGraphicsLayer()
                                .paint(
                                    painter = painterResource(it.image),
                                    contentScale = ContentScale.FillWidth
                                )
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.name,
                            textAlign = TextAlign.Center,
                            style = AkaTheme.typography.titleLarge
                        )
                    }
                }
            }
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AkaTheme.spacing.size24),
                    text = "Components",
                    style = AkaTheme.typography.headlineSmall
                )
            }
            items(componentScreens, key = { it.name }, contentType = { it }) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .heightIn(min = 272.dp),
                    shape = AkaTheme.shapes.shape20,
                    border = BorderStroke(
                        width = 1.dp,
                        color = AkaTheme.colorScheme.outline
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate(it.navigation)
                            }
                            .padding(AkaTheme.spacing.size12),
                        verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size8)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(AkaTheme.shapes.shape10)
                                .clipToBounds()
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .toolingGraphicsLayer()
                                .paint(
                                    painter = painterResource(it.image),
                                    colorFilter = null,
                                    contentScale = ContentScale.FillWidth
                                )
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.name,
                            textAlign = TextAlign.Center,
                            style = AkaTheme.typography.titleLarge
                        )
                    }
                }
            }
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                Spacer(
                    modifier = Modifier
                        .windowInsetsBottomHeight(WindowInsets.navigationBars)
                )
            }
        }
    }
}
