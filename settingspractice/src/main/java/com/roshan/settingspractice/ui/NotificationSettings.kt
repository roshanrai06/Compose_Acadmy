package com.roshan.settingspractice.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.roshan.settingspractice.R
import com.roshan.settingspractice.Tags.TAG_TOGGLE_ITEM


@Composable
fun NotificationSettings(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onCheckedChanged: (() -> Unit)
) {
    val notificationsSettingState = if (checked) {
        stringResource(id = R.string.cd_notifications_enabled)
    } else {
        stringResource(id = R.string.cd_notifications_disabled)
    }
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .testTag(TAG_TOGGLE_ITEM)
                .toggleable(
                    value = checked,
                    onValueChange = {
                        onCheckedChanged()
                    }, role = Role.Switch
                )
                .semantics {
                    stateDescription = notificationsSettingState
                }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title
            )
            Switch(
                checked = checked,
                onCheckedChange = null
            )
        }
    }

}