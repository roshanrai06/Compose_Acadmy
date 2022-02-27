package com.roshan.settingspractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roshan.settingspractice.R
import com.roshan.settingspractice.SettingsViewModel
import com.roshan.settingspractice.model.SettingsState

@Composable
fun Settings() {
    val settingsViewModel: SettingsViewModel = viewModel()
    MaterialTheme {
        val state = settingsViewModel.uiState.collectAsState().value
        SettingsList(
            modifier = Modifier.fillMaxSize(),
            state = state,
            toggleNotificationSetting = settingsViewModel::toggleNotificationSettings,
            toggleHintsSetting = settingsViewModel::toggleHintSetting
        )

    }

}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    toggleNotificationSetting: () -> Unit,
    toggleHintsSetting: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {

            Icon(
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(
                    id = R.string.cd_go_back
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.title_settings),
                color = MaterialTheme.colors.onSurface,
                fontSize = 18.sp
            )
        }

        Divider()

        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_enable_notifications), checked =
            state.notificationsEnabled,
            onToggleNotificationsSettings = toggleNotificationSetting
        )
        Divider()
        HintSettingsItem(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_show_hints), checked =
            state.hintsEnabled,
            onShowHintsToggled = toggleHintsSetting
        )
        Divider()
        ManageSubscriptionSettingItem(modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.subscription_settings),

            onSettingClicked = {
                {

                }
            }
        )
        SectionSpacer(modifier = Modifier.fillMaxWidth())


    }

}