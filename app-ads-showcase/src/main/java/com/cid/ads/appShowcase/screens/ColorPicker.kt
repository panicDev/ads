package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.cid.ads.colorPicker.ColorPicker
import com.cid.ads.colorPicker.view.util.rememberColorPickerState
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold

object ColorPicker : Screen {
    override val name: String = "Color picker"

    override val image: Int = R.drawable.color_picker

    override val navigation: String = "colorPicker"

    @Composable
    override fun Content(navController: NavController?) {
        var showDialog by remember { mutableStateOf(false) }

        val state = rememberColorPickerState(
            initialColor = AkaTheme.colorScheme.primary,
            isSupportOpacity = true
        )
        SampleScaffold(title = name, onBackClick = { navController?.navigateUp() }) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(state.selectedColor)
                    .clickable {
                        showDialog = true
                    }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AkaTheme.spacing.size20),
                    text = "Select background color",
                    textAlign = TextAlign.Center,
                    style = AkaTheme.typography.titleLarge,
                    color = AkaTheme.colorScheme.onSurface
                )
            }
        }

        if (showDialog) {
            ColorPicker(
                state = state,
                onDismissRequest = {
                    showDialog = false
                }
            )
        }
    }
}