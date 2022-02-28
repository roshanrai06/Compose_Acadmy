package com.roshan.settingspractice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.roshan.settingspractice.Tags.TAG_TOGGLE_ITEM
import com.roshan.settingspractice.ui.NotificationSettings
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotificationSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Display() {
        val title = "Enable Notifications"

        composeTestRule.setContent {
            NotificationSettings(title = title, checked = true, onCheckedChanged = {})

        }
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun Setting_Checked() {
        val title = "Enable Notifications"

        composeTestRule.setContent {
            NotificationSettings(title = title, checked = true, onCheckedChanged = {})

        }
        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
    }
}