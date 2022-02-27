package com.roshan.settingspractice.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roshan.settingspractice.R
import com.roshan.settingspractice.model.MarketingOption

@Composable

fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.setting_options_marketing_choice)
    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
            Text(text = stringResource(id = R.string.setting_option_marketing))
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selectedOption.id == index, onClick = {
                                val marketingOption =
                                    if (index == MarketingOption.ALLOWED.id) {
                                        MarketingOption.ALLOWED
                                    } else {
                                        MarketingOption.NOT_ALLOWED
                                    }
                                onOptionSelected(marketingOption)
                            }, role = Role.RadioButton
                        )
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )
                    Text(
                        modifier = Modifier.padding(start = 18.dp),
                        text = option
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun Preview_MarketingSettingItem() {
    MaterialTheme {
        MarketingSettingItem(
            modifier = Modifier.fillMaxWidth(),
            selectedOption = MarketingOption.ALLOWED,
            onOptionSelected = { }
        )
    }
}