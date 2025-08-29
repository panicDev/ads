package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cid.ads.codeInput.FourDigitCodeInput
import com.cid.ads.codeInput.SixDigitCodeInput
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.internal.SecureInputSettings
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object CodeInput : Screen {
    override val name: String = "Code input"

    override val image: Int = R.drawable.code_input

    override val navigation: String = "codeInput"

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
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                var isSuccess by remember { mutableStateOf(false) }
                var isError by remember { mutableStateOf(false) }
                var enabled by remember { mutableStateOf(true) }
                var secret by remember { mutableStateOf(false) }
                val fourInput = rememberTextFieldState("")
                val sixInput = rememberTextFieldState("")

                var selectedStyle by remember { mutableStateOf("Four") }
                val styleState = remember {
                    listOf(
                        mutableStateOf(true),
                        mutableStateOf(false),
                    )
                }

                SampleRow(text = "Sample") {
                    when (selectedStyle) {
                        "Four" -> {
                            FourDigitCodeInput(
                                modifier = Modifier.fillMaxWidth(),
                                state = fourInput,
                                enabled = enabled,
                                isValid = isSuccess,
                                isError = isError,
                                secure = if (secret) SecureInputSettings.Secure() else SecureInputSettings.NotSecure,
                            )
                        }

                        "Six" -> {
                            SixDigitCodeInput(
                                modifier = Modifier.fillMaxWidth(),
                                state = sixInput,
                                enabled = enabled,
                                isValid = isSuccess,
                                isError = isError,
                                secure = if (secret) SecureInputSettings.Secure() else SecureInputSettings.NotSecure,
                            )
                        }
                    }
                }
                FormItem(
                    subhead = { Subhead(text = "Style") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Four digits",
                                selected = styleState[0].value,
                                onSelectedChange = {
                                    styleState.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                    selectedStyle = "Four"
                                }
                            )
                            RadioButton(
                                text = "Six digits",
                                selected = styleState[1].value,
                                onSelectedChange = {
                                    styleState.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                    selectedStyle = "Six"
                                }
                            )
                        }
                    }
                )
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            Checkbox(
                                text = "Enabled",
                                checked = enabled,
                                onCheckedChange = { isChecked ->
                                    enabled = isChecked
                                }
                            )
                            Checkbox(
                                text = "Valid",
                                checked = isSuccess,
                                onCheckedChange = { isChecked ->
                                    isSuccess = isChecked
                                }
                            )
                            Checkbox(
                                text = "Error",
                                checked = isError,
                                onCheckedChange = { isChecked ->
                                    isError = isChecked
                                }
                            )
                            Checkbox(
                                text = "Secret",
                                checked = secret,
                                onCheckedChange = { isChecked ->
                                    secret = isChecked
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}