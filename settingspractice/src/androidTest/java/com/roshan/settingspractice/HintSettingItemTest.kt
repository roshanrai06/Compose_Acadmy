package com.roshan.settingspractice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.roshan.settingspractice.Tags.TAG_CHECK_ITEM
import com.roshan.settingspractice.ui.HintSettingsItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HintSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Displayed() {
        val title = "Show Hints"

        composeTestRule.setContent {
            HintSettingsItem(title = title, checked = true, onShowHintsToggled = {})

        }
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun Setting_Checked(){
        val title = "Show Hints"

        composeTestRule.setContent {
            HintSettingsItem(title = title, checked = true, onShowHintsToggled = {})

        }
        composeTestRule.onNodeWithTag(TAG_CHECK_ITEM).assertIsOn()


    }
}