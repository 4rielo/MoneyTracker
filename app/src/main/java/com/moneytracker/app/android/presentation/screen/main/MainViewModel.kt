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

    init {
        hello.value = "Hello World"
        getStoredTransactions()
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