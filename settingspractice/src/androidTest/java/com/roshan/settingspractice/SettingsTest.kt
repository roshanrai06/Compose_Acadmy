package com.roshan.settingspractice

import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.roshan.settingspractice.Tags.TAG_TOGGLE_ITEM
import com.roshan.settingspractice.ui.Settings
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SettingsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Enable_Notification_Setting_Is_Display() {
        assertSettingIsDisplayed(R.string.setting_enable_notifications)
    }

    @Test
    fun Show_Hints_Setting_Is_Display() {
        assertSettingIsDisplayed(R.string.setting_show_hints)
    }

    @Test
    fun View_Subscription_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.subscription_settings
        )
    }

    @Test
    fun App_Version_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_app_version
        )
    }

    @Test
    fun Theme_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_theme
        )
    }

    @Test
    fun Marketing_Options_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_marketing
        )
    }

    private fun assertSettingIsDisplayed(@StringRes title: Int) {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(
                title
            )
        )
    }

    @Test
    fun Enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.setting_enable_notifications)
        ).performClick()
        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
    }

    @Test
    fun Show_Hints_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.setting_show_hints)
        ).performClick()
        composeTestRule.onNodeWithTag(Tags.TAG_CHECK_ITEM).assertIsOn()
    }

    @Test
    fun Marketing_Options_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(R.array.setting_options_marketing_choice)[1]
        ).performClick()
        composeTestRule.onNodeWithTag(Tags.TAG_MARKETING_OPTION+1).assertIsSelected()
    }
}