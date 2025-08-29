package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Input
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.input.Input
import com.cid.ads.input.InputsDefaults
import com.cid.ads.internal.SecureInputSettings
import com.cid.ads.topAppBar.TopAppBarDefaults
import com.cid.ads.topAppBar.rememberTopAppBarState
import com.cid.adsSymbols.eye.Eye
import com.cid.adsSymbols.eye.slash.EyeSlash
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.user.User
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Input : Screen {
    override val name: String = "Input"

    override val image: Int = R.drawable.input

    override val navigation: String = "input"

    @Composable
    override fun Content(navController: NavController?) {
        val topAppBarScrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        val placeholderValue = rememberTextFieldState("Placeholder")
        val input = rememberTextFieldState()
        var visible by remember { mutableStateOf(false) }
        val (enabled, onEnabledChange) = remember { mutableStateOf(true) }
        val (isError, onIsErrorChange) = remember { mutableStateOf(false) }
        val (isSuccess, onIsSuccessChange) = remember { mutableStateOf(false) }
        val (placeholder, onPlaceholderChange) = remember { mutableStateOf(false) }
        val (password, onPasswordChange) = remember { mutableStateOf(false) }
        val (leading, onLeadingChange) = remember { mutableStateOf(false) }
        val (trailing, onTrailingChange) = remember { mutableStateOf(false) }
        val (suffix, onSuffixChange) = remember { mutableStateOf(false) }

        val colors = InputsDefaults.outlineColors()
        var colorsState by remember { mutableStateOf(colors) }

        val styleStates = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false)
            )
        }


        val plain = InputsDefaults.plainColors()
        val outline = InputsDefaults.outlineColors()
        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() },
            topAppBarScrollBehavior = topAppBarScrollBehavior
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .padding(it),
            ) {
                SampleRow(text = "Sample", firstItem = true) {
                    Input(
                        state = input,
                        enabled = enabled,
                        colors = colorsState,
                        isError = isError,
                        isValid = isSuccess,
                        placeholder = if (placeholder) placeholderValue.text.toString() else null,
                        secure = if (password) SecureInputSettings.Secure(visible = visible) else SecureInputSettings.NotSecure,
                        leadingIcon = if (leading) rememberVectorPainter(image = IdsSymbols.Default.User) else null,
                        trailingIcon = if (trailing) rememberVectorPainter(image = if (visible) IdsSymbols.Default.EyeSlash else IdsSymbols.Default.Eye) else null,
                        suffix = if (suffix) "12" else null,
                        onTrailingIconClick = { visible = !visible }
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Style") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Outlined",
                                selected = styleStates[0].value,
                                onSelectedChange = {
                                    styleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                    colorsState = outline
                                }
                            )
                            RadioButton(
                                text = "Plain",
                                selected = styleStates[1].value,
                                onSelectedChange = {
                                    styleStates.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                    colorsState = plain
                                }
                            )
                        }
                    }
                )
                if (placeholder) {
                    FormItem(
                        subhead = { Subhead(text = "Placeholder") },
                        content = { Input(state = placeholderValue) }
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            Checkbox(
                                text = "Enabled",
                                checked = enabled,
                                onCheckedChange = onEnabledChange
                            )
                            Checkbox(
                                text = "Error",
                                checked = isError,
                                onCheckedChange = onIsErrorChange
                            )
                            Checkbox(
                                text = "Valid",
                                checked = isSuccess,
                                onCheckedChange = onIsSuccessChange
                            )
                            Checkbox(
                                text = "Placeholder",
                                checked = placeholder,
                                onCheckedChange = onPlaceholderChange
                            )
                            Checkbox(
                                text = "Password",
                                checked = password,
                                onCheckedChange = onPasswordChange
                            )
                            Checkbox(
                                text = "Leading Icon",
                                checked = leading,
                                onCheckedChange = onLeadingChange
                            )
                            Checkbox(
                                text = "Trailing Icon",
                                checked = trailing,
                                onCheckedChange = onTrailingChange
                            )
                            Checkbox(
                                text = "Suffix",
                                checked = suffix,
                                onCheckedChange = onSuffixChange
                            )
                        }
                    }
                )

            }
        }
    }
}