package com.moneytracker.app.android.presentation.screen.main

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneytracker.app.android.domain.database.TransactionsDatabaseDAO
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.domain.model.TransactionModel
import com.moneytracker.app.android.presentation.mvvm.MutableEmptyEventLiveData
import com.moneytracker.app.android.presentation.util.CalculatorOperation
import com.moneytracker.app.android.presentation.util.CalculatorState
import com.moneytracker.app.android.presentation.util.InputDialogActions
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val transactionsDatabaseDAO: TransactionsDatabaseDAO): ViewModel() {
    private val _transactions = MutableLiveData<List<TransactionEntity>>()
    val transactions: LiveData<List<TransactionEntity>> = _transactions

    val addNewItem = MutableEmptyEventLiveData()

    val hello = MutableLiveData<String>()

    var state by mutableStateOf(CalculatorState())
        private set

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    init {
        hello.value = "Hello World"
        //getStoredTransactions()
    }

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

    private fun getStoredTransactions() {
        viewModelScope.launch {
            try {
                val transactionsDataSet = transactionsDatabaseDAO.getAllTransactions()
                _transactions.value = transactionsDataSet
            } catch (e: Exception) {
                Log.d("Exception ocurred",e.toString())
            }
        }
    }

    private fun saveNewTransaction(transaction: TransactionEntity) {
        viewModelScope.launch {
            try {
                //transactionsDatabaseDAO.insert(transaction)
            } catch (e: Exception) {

            }
        }
        getStoredTransactions()
    }

    fun storeNewTransaction(transaction: TransactionEntity) {
        saveNewTransaction(transaction)
    }

    fun changeText() {
        hello.value = "This is a random text"
    }

    fun addItem() {
        addNewItem.sendEvent()
    }
}