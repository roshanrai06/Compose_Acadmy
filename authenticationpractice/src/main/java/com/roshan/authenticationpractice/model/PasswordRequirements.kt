package com.roshan.authenticationpractice.model

import androidx.annotation.StringRes
import com.roshan.authenticationpractice.R

enum class PasswordRequirements(@StringRes val label: Int) {
    CAPITAL_LETTER(R.string.requirement_capital),
    NUMBER(R.string.requirement_digit),
    EIGHT_CHARACTERS(R.string.requirement_characters)
}