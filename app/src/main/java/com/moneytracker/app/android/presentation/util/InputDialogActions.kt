package com.moneytracker.app.android.presentation.util

sealed class InputDialogActions {
    data class Number(val number: Int): InputDialogActions()
    object Clear: InputDialogActions()
    object Delete: InputDialogActions()
    object Decimal: InputDialogActions()
    object Calculate: InputDialogActions()
    data class Operation(val operation: CalculatorOperation): InputDialogActions()
}