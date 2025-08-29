package com.cid.ads.appShowcase.componets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.cid.ads.scafold.Scaffold
import com.cid.ads.snackbar.SnackbarHost
import com.cid.ads.snackbar.SnackbarHostState
import com.cid.ads.topAppBar.IconButton
import com.cid.ads.topAppBar.TopAppBar
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.TopAppBarScrollBehavior
import com.cid.adsSymbols.arrow.left.ArrowLeft
import com.cid.adsSymbols.foundation.IdsSymbols

@Composable
fun SampleScaffold(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    topAppBarScrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    navigationBar: @Composable () -> Unit = {},
    content: @Composable (padding: PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                leading = onBackClick?.let {
                    {
                        IconButton(
                            icon = rememberVectorPainter(IdsSymbols.Default.ArrowLeft),
                            onClick = onBackClick
                        )
                    }
                },
                title = title,
                scrollBehavior = topAppBarScrollBehavior,
            )
        },
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        content = {
            content(it)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = navigationBar
    )
}