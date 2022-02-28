package com.roshan.settingspractice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.roshan.settingspractice.Tags.TAG_SELECT_THEME
import com.roshan.settingspractice.Tags.TAG_THEME
import com.roshan.settingspractice.Tags.TAG_THEME_OPTION
import com.roshan.settingspractice.model.Theme
import com.roshan.settingspractice.ui.ThemeSettingItem
import org.junit.Rule
import org.junit.Test

class ThemeSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Selected_Theme_Displayed() {
        val option = Theme.DARK

        composeTestRule.setContent {
            ThemeSettingItem(selectedTheme = option, onThemeSelected = {})
        }
        composeTestRule.onNodeWithTag(TAG_THEME, useUnmergedTree = true).assertTextEquals(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(option.label)
        )
    }

    @Test
    fun Theme_Options_Displayed() {
        val option = Theme.DARK

        composeTestRule.setContent {
            ThemeSettingItem(selectedTheme = option, onThemeSelected = {})
        }
        composeTestRule.onNodeWithTag(TAG_SELECT_THEME, useUnmergedTree = true).performClick()

        Theme.values().forEach {
            composeTestRule.onNodeWithTag(
                TAG_THEME_OPTION + InstrumentationRegistry.getInstrumentation().targetContext.getString(
                    it.label
                ), useUnmergedTree = true
            ).assertIsDisplayed()
        }
    }
}