package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.pageIndicator.IndicatorStyle
import com.cid.ads.pageIndicator.PageIndicator
import com.cid.ads.text.Text
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold

object PageIndicator : Screen {

    override val name: String = "Page indicator"

    override val image: Int = R.drawable.page_indicator

    override val navigation: String = "page_indicator"

    @Composable
    override fun Content(navController: NavController?) {
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() }
        ) {

            val pagerState = rememberPagerState { 5 }
            val list = listOf(Color.Red, Color.Cyan, Color.Blue, Color.Green, Color.Magenta)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    AkaTheme.spacing.size24,
                    Alignment.CenterVertically
                )
            ) {
                Box {
                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxSize(),
                        state = pagerState
                    ) { index ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(list[index]),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (index + 1).toString(),
                                style = AkaTheme.typography.displayLarge,
                                color = AkaTheme.colorScheme.onSurface
                            )
                        }
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(bottom = AkaTheme.spacing.size24)
                            .navigationBarsPadding(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(AkaTheme.spacing.size12)
                    ) {
                        PageIndicator(
                            pagerState = pagerState,
                            visibleIndicatorCount = 5,
                            style = IndicatorStyle.LINE
                        )
                        PageIndicator(
                            pagerState = pagerState,
                            visibleIndicatorCount = 3,
                            style = IndicatorStyle.DOT
                        )
                    }
                }
            }
        }
    }
}