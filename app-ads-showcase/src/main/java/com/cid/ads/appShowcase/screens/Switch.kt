package com.cid.ads.appShowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.navigation.NavController
import com.cid.ads.formItem.Checkbox
import com.cid.ads.formItem.Checkboxes
import com.cid.ads.formItem.FormItem
import com.cid.ads.formItem.Subhead
import com.cid.ads.switch.Switch
import com.cid.adsSymbols.check.Check
import com.cid.adsSymbols.foundation.IdsSymbols
import com.cid.adsSymbols.xmark.XMark
import com.cid.ads.appShowcase.R
import com.cid.ads.appShowcase.componets.SampleRow
import com.cid.ads.appShowcase.componets.SampleScaffold

object Switch : Screen {
    override val name: String = "Switch"

    override val image: Int = R.drawable._switch

    override val navigation: String = "switch"

    @Composable
    override fun Content(navController: NavController?) {
        val (checked, onCheckedChange) = remember { mutableStateOf(false) }
        val (leading, onLeadingChange) = remember { mutableStateOf(false) }
        val (trailing, onTrailingChange) = remember { mutableStateOf(false) }
        val (enabled, onEnabledChange) = remember { mutableStateOf(true) }

        SampleScaffold(
            title = name,
            onBackClick = { navController?.navigateUp() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                SampleRow(text = "Sample") {
                    Switch(
                        enabled = enabled,
                        checked = checked,
                        onCheckedChange = onCheckedChange,
                        checkedIcon = if (trailing) rememberVectorPainter(image = IdsSymbols.Default.Check) else null,
                        uncheckedIcon = if (leading) rememberVectorPainter(image = IdsSymbols.Default.XMark) else null,
                    )
                }
                FormItem(
                    subhead = { Subhead(text = "Settings") },
                    content = {
                        Checkboxes {
                            Checkbox(
                                text = "Unchecked icon",
                                checked = leading,
                                onCheckedChange = onLeadingChange
                            )
                            Checkbox(
                                text = "Checked icon",
                                checked = trailing,
                                onCheckedChange = onTrailingChange
                            )
                            Checkbox(
                                text = "Enabled",
                                checked = enabled,
                                onCheckedChange = onEnabledChange
                            )
                        }
                    }
                )
            }
        }
    }
}