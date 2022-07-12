package com.moneytracker.app.android.presentation.screen.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneytracker.app.android.domain.database.TransactionsDatabaseDAO
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.presentation.mvvm.MutableEmptyEventLiveData
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val transactionsDatabaseDAO: TransactionsDatabaseDAO): ViewModel() {
    private val _transactions = MutableLiveData<List<TransactionEntity>>()
    val transactions: LiveData<List<TransactionEntity>> = _transactions

    val addNewItem = MutableEmptyEventLiveData()

    init {
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

    fun addItem() {
        addNewItem.sendEvent()
    }
}