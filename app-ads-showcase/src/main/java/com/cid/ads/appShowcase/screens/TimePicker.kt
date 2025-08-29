package com.cid.ads.appShowcase.screens

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.cid.ads.button.Button
import com.cid.ads.button.ButtonDefaults
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.timePicker.TimePicker
import com.cid.ads.timePicker.state.rememberTimePickerState
import com.cid.ads.timePicker.util.PickerType
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold
import java.util.Locale

object TimePicker : Screen {

    override val name: String = "Time picker"

    override val image: Int = R.drawable.time_picker

    override val navigation: String = "timePicker"

    @Composable
    override fun Content(navController: NavController?) {
        var showDialog by remember { mutableStateOf(false) }
        val (is24HFormat, onFormatChange) = remember { mutableStateOf(false) }
        val states = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false),
            )
        }
        val timeState by remember {
            mutableStateOf(Calendar.getInstance())
        }
        val state = rememberTimePickerState(
            initialHour = timeState.get(Calendar.HOUR_OF_DAY),
            initialMinute = timeState.get(Calendar.MINUTE),
            is24Hour = is24HFormat
        )
        var time by remember { mutableStateOf("") }

        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = AkaTheme.spacing.size12)
                    .navigationBarsPadding(),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16),
                    text = time,
                    textAlign = TextAlign.Center,
                    style = AkaTheme.typography.displayLarge,
                    color = AkaTheme.colorScheme.onSurface
                )
                FormItem(
                    subhead = { Subhead(text = "Style") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Wheel",
                                selected = states[0].value,
                                onSelectedChange = {
                                    states.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                }
                            )
                            RadioButton(
                                text = "Dial",
                                selected = states[1].value,
                                onSelectedChange = {
                                    states.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
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
                                text = "24H format",
                                checked = is24HFormat,
                                onCheckedChange = onFormatChange
                            )
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16)
                        .padding(top = AkaTheme.spacing.size8),
                    text = "Time Picker",
                    sizes = ButtonDefaults.largeSizes(),
                    onClick = {
                        showDialog = true
                    }
                )
            }
        }
        if (showDialog) {
            TimePicker(
                state = state,
                pickerType = when {
                    states[0].value -> PickerType.WHEEL
                    states[1].value -> PickerType.DIAL
                    else -> PickerType.WHEEL
                },
                onConfirm = {
                    showDialog = false
                    timeState.set(Calendar.HOUR_OF_DAY, state.hour)
                    timeState.set(Calendar.MINUTE, state.minute)
                    time = String.format(Locale.getDefault(), "%02d:%02d", state.hour, state.minute)
                },
                onDismissRequest = {
                    showDialog = false
                },
            )
        }
    }
}