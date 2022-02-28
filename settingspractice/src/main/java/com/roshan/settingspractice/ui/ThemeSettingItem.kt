package com.roshan.settingspractice.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.roshan.settingspractice.R
import com.roshan.settingspractice.Tags.TAG_SELECT_THEME
import com.roshan.settingspractice.Tags.TAG_THEME
import com.roshan.settingspractice.Tags.TAG_THEME_OPTION
import com.roshan.settingspractice.model.Theme


@Composable

fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onThemeSelected: (option: Theme) -> Unit
) {
    SettingItem(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .clickable(
                    onClick = { expanded = !expanded },
                    onClickLabel = stringResource(id = R.string.cd_select_theme)
                )
                .padding(16.dp)
                .testTag(TAG_SELECT_THEME)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(
                modifier = Modifier.testTag(TAG_THEME),
                text = stringResource(id = selectedTheme.label)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            offset = DpOffset(16.dp, 0.dp)
        ) {
            Theme.values().forEach { theme ->
                val themeLabel = stringResource(id = theme.label)
                DropdownMenuItem(
                    modifier = Modifier.testTag(TAG_THEME_OPTION + themeLabel),
                    onClick = {
                        onThemeSelected(theme)
                        expanded = false
                    }) {
                    Text(text = themeLabel)
                }
            }
        }

    }

}