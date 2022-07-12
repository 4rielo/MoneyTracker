package com.moneytracker.app.android.presentation.screen.inputdialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.moneytracker.app.android.presentation.screen.main.MainViewModel
import com.moneytracker.app.android.presentation.util.CalculatorOperation
import com.moneytracker.app.android.presentation.util.CalculatorState
import com.moneytracker.app.android.presentation.util.InputDialogActions

class KeyPadViewModel: ViewModel() {

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: InputDialogActions) {
        when(action) {
            is InputDialogActions.Number -> enterNumber(action.number)
            is InputDialogActions.Decimal -> enterDecimal()
            is InputDialogActions.Clear -> state = CalculatorState()
            is InputDialogActions.Operation -> enterOperation(action.operation)
            is InputDialogActions.Calculate -> performCalculation()
            is InputDialogActions.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Multiply -> number1 * number2
                else -> return
            }
            state = state.copy(
                number1 = result.toString(),
                operation = null,
                number2 = ""
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains('.') && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + '.')
            return
        }
        if(!state.number2.contains('.') && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + '.')
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) return
        state = state.copy(number2 = state.number2 + number)
    }
}