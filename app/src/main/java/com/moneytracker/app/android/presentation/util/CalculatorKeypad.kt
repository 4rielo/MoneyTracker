package com.moneytracker.app.android.presentation.util

import androidx.compose.ui.graphics.Color

data class CalculatorKeypad(
    val symbol: String,
    val action: InputDialogActions,
    val aspectRatio: Float,
    val weight: Float,
    val backgroundColor: Color,
)