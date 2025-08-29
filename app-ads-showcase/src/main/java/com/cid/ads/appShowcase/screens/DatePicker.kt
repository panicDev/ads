package com.cid.ads.appShowcase.screens

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cid.ads.button.Button
import com.cid.ads.button.ButtonDefaults
import com.cid.ads.datePicker.DatePicker
import com.cid.ads.datePicker.view.util.DatePickerConfig
import com.cid.ads.datePicker.view.util.DatePickerSelection
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.RadioButton
import com.cid.ads.formItem.RadioButtons
import com.cid.ads.formItem.Subhead
import com.cid.ads.foundation.AkaTheme
import com.cid.ads.text.Text
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleScaffold
import java.text.SimpleDateFormat
import java.util.Locale

object DatePicker : Screen {

    override val name: String = "Date picker"

    override val image: Int = R.drawable.date_picker

    override val navigation: String = "darePicker"

    @Composable
    override fun Content(navController: NavController?) {
        var showDialog by remember { mutableStateOf(false) }
        val (selectable, selectionChange) = remember { mutableStateOf(false) }

        val selectionTypeState = remember {
            listOf(
                mutableStateOf(true),
                mutableStateOf(false),
                mutableStateOf(false)
            )
        }

        var selected by remember {
            mutableStateOf(
                Calendar.getInstance().apply {
                    firstDayOfWeek = Calendar.MONDAY
                }
            )
        }

        var selectedDates by remember {
            mutableStateOf(emptyList<Calendar>())
        }

        var startDate by remember {
            mutableStateOf(
                Calendar.getInstance().apply {
                    firstDayOfWeek = Calendar.MONDAY
                }
            )
        }

        var endDate by remember {
            mutableStateOf(
                Calendar.getInstance().apply {
                    firstDayOfWeek = Calendar.MONDAY
                    add(Calendar.DAY_OF_MONTH, 1)
                }
            )
        }

        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        val dates = StringBuilder()

        selectedDates.forEach {
            dates.append(dateFormat.format(it.timeInMillis) + " ")
        }

        SampleScaffold(title = name, onBackClick = { navController?.navigateUp() }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16)
                        .padding(top = AkaTheme.spacing.size4),
                    text = "Date: ${dateFormat.format(selected.timeInMillis)}"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16)
                        .padding(top = AkaTheme.spacing.size4),
                    text = "Dates: $dates"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16)
                        .padding(top = AkaTheme.spacing.size4),
                    text = "Period: ${dateFormat.format(startDate.timeInMillis)} - " +
                            dateFormat.format(endDate.timeInMillis)
                )
                FormItem(
                    subhead = { Subhead(text = "Selection type") },
                    content = {
                        RadioButtons {
                            RadioButton(
                                text = "Date selection",
                                selected = selectionTypeState[0].value,
                                onSelectedChange = {
                                    selectionTypeState.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 0
                                    }
                                }
                            )
                            RadioButton(
                                text = "Dates selection",
                                selected = selectionTypeState[1].value,
                                onSelectedChange = {
                                    selectionTypeState.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 1
                                    }
                                }
                            )
                            RadioButton(
                                text = "Range selection",
                                selected = selectionTypeState[2].value,
                                onSelectedChange = {
                                    selectionTypeState.forEachIndexed { index, mutableState ->
                                        mutableState.value = index == 2
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
                                text = "Selectable Month And Year",
                                checked = selectable,
                                onCheckedChange = selectionChange
                            )
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AkaTheme.spacing.size16)
                        .padding(top = AkaTheme.spacing.size8),
                    text = "Show date picker",
                    sizes = ButtonDefaults.largeSizes(),
                    onClick = {
                        showDialog = true
                    }
                )
            }
        }
        if (showDialog) {
            DatePicker(
                config = DatePickerConfig(
                    selectable = selectable
                ),
                selection = when {
                    selectionTypeState[0].value -> DatePickerSelection.Date(
                        selectedDate = selected,
                        onDateSelected = {
                            selected = it
                        }
                    )

                    selectionTypeState[1].value -> DatePickerSelection.Dates(
                        selectedDates = selectedDates,
                        onDatesSelected = {
                            selectedDates = it
                        }
                    )

                    selectionTypeState[2].value -> DatePickerSelection.Period(
                        selectedRange = startDate..endDate,
                        onRangeSelected = { first: Calendar, second: Calendar ->
                            startDate = first
                            endDate = second
                        }
                    )

                    else -> DatePickerSelection.Date(
                        selectedDate = selected,
                        onDateSelected = {
                            selected = it
                        }
                    )
                },
                onDismissRequest = {
                    showDialog = false
                },
            )
        }
    }
}