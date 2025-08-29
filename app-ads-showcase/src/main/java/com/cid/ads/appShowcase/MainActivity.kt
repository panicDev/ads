package com.cid.ads.appShowcase

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Left
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Right
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.appShowcase.screens.ActionSheet
import com.cid.ads.appShowcase.screens.Alert
import com.cid.ads.appShowcase.screens.AvatarAndImage
import com.cid.ads.appShowcase.screens.Banner
import com.cid.ads.appShowcase.screens.Button
import com.cid.ads.appShowcase.screens.Checkbox
import com.cid.ads.appShowcase.screens.Chips
import com.cid.ads.appShowcase.screens.CodeInput
import com.cid.ads.appShowcase.screens.ColorPicker
import com.cid.ads.appShowcase.screens.ColorScheme
import com.cid.ads.appShowcase.screens.Counter
import com.cid.ads.appShowcase.screens.DatePicker
import com.cid.ads.appShowcase.screens.Divider
import com.cid.ads.appShowcase.screens.Elevation
import com.cid.ads.appShowcase.screens.Fab
import com.cid.ads.appShowcase.screens.FormItem
import com.cid.ads.appShowcase.screens.IconButton
import com.cid.ads.appShowcase.screens.Input
import com.cid.ads.appShowcase.screens.ListItem
import com.cid.ads.appShowcase.screens.ModalPage
import com.cid.ads.appShowcase.screens.NavigationBar
import com.cid.ads.appShowcase.screens.PageIndicator
import com.cid.ads.appShowcase.screens.ProgressIndicator
import com.cid.ads.appShowcase.screens.RadioButton
import com.cid.ads.appShowcase.screens.Section
import com.cid.ads.appShowcase.screens.SegmentedControls
import com.cid.ads.appShowcase.screens.Select
import com.cid.ads.appShowcase.screens.Shapes
import com.cid.ads.appShowcase.screens.Skeleton
import com.cid.ads.appShowcase.screens.Slider
import com.cid.ads.appShowcase.screens.Snackbar
import com.cid.ads.appShowcase.screens.Spacing
import com.cid.ads.appShowcase.screens.Switch
import com.cid.ads.appShowcase.screens.Symbols
import com.cid.ads.appShowcase.screens.Tabs
import com.cid.ads.appShowcase.screens.TextArea
import com.cid.ads.appShowcase.screens.TimePicker
import com.cid.ads.appShowcase.screens.TopAppBar
import com.cid.ads.appShowcase.screens.Typography

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )

        setContent {
            AkaTheme {
                val navController = rememberNavController()
                val foundationScreens = listOf(
                    Skeleton,
                    Symbols,
                    ColorScheme,
                    Typography,
                    Shapes,
                    Spacing,
                    Elevation
                )
                val componentScreens =
                    arrayListOf(
                        ActionSheet,
                        Alert,
                        Button,
                        AvatarAndImage,
                        Banner,
                        Checkbox,
                        Counter,
                        Divider,
                        Fab,
                        FormItem,
                        IconButton,
                        Input,
                        ModalPage,
                        NavigationBar,
                        ProgressIndicator,
                        RadioButton,
                        Snackbar,
                        Tabs,
                        TextArea,
                        TopAppBar,
                        CodeInput,
                        DatePicker,
                        Switch,
                        /*Charts,*/
                        PageIndicator,
                        TimePicker,
                        Chips,
                        Select,
                        ColorPicker,
                        ListItem,
                        Slider,
                        SegmentedControls,
                        Section
                    )
                NavHost(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(PaddingValues(0.dp))
                        .consumeWindowInsets(PaddingValues(0.dp))
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal,
                            ),
                        ),
                    navController = navController,
                    startDestination = "dashboard"
                ) {
                    composable(
                        "dashboard",
                        enterTransition = {
                            slideIntoContainer(
                                towards = Left,
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                towards = Left,
                            )
                        },
                        popEnterTransition = {
                            slideIntoContainer(
                                towards = Right,
                            )
                        },
                        popExitTransition = {
                            slideOutOfContainer(
                                towards = Right,
                            )
                        }
                    ) { _ ->
                        DashboardScreen(
                            navController,
                            foundationScreens.sortedBy { it.name },
                            componentScreens.sortedBy { it.name }
                        )
                    }
                    foundationScreens.forEach { screen ->
                        composable(
                            screen.navigation,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = Left,
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = Left,
                                )
                            },
                            popEnterTransition = {
                                slideIntoContainer(
                                    towards = Right,
                                )
                            },
                            popExitTransition = {
                                slideOutOfContainer(
                                    towards = Right,
                                )
                            }
                        ) { screen.Content(navController) }
                    }
                    componentScreens.forEach { screen ->
                        composable(
                            screen.navigation,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = Left,
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = Left,
                                )
                            },
                            popEnterTransition = {
                                slideIntoContainer(
                                    towards = Right,
                                )
                            },
                            popExitTransition = {
                                slideOutOfContainer(
                                    towards = Right,
                                )
                            }
                        ) { screen.Content(navController) }
                    }
                }
            }
        }
    }
}