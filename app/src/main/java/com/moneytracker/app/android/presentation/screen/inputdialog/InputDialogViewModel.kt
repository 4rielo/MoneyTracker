package com.moneytracker.app.android.presentation.screen.inputdialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.moneytracker.app.android.presentation.util.CalculatorState

class InputDialogViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set
}