package com.roshan.settingspractice

import androidx.lifecycle.ViewModel
import com.roshan.settingspractice.model.MarketingOption
import com.roshan.settingspractice.model.SettingsState
import com.roshan.settingspractice.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings() {
        uiState.value =
            uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintSetting() {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun setMarketingSettings(option: MarketingOption) {
        uiState.value = uiState.value.copy(marketingOption = option)
    }

    fun setTheme(theme: Theme) {
        uiState.value = uiState.value.copy(themeOption = theme)
    }
}