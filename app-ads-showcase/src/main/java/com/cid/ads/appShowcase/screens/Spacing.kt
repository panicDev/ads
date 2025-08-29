package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Spacing : Screen {
    override val name: String = "Spacing"
    override val image: Int = R.drawable.spacing
    override val navigation: String = "spacing"

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
                SampleRow(text = "2dp", firstItem = true) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size2)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "4dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size4)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "6dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size6)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "8dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size8)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "10dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size10)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "12dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size12)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "14dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size14)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "16dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size16)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "18dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size18)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "20dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size20)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "22dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size22)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
                SampleRow(text = "24dp") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AkaTheme.spacing.size24)
                            .background(AkaTheme.colorScheme.onSurface)
                    )
                }
            }
        }
    }
}