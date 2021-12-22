package com.moneytracker.app.android.presentation.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moneytracker.app.android.domain.model.TransactionModel
import com.moneytracker.app.android.presentation.mvvm.EmptyEventLiveData
import com.moneytracker.app.android.presentation.mvvm.MutableEmptyEventLiveData
import com.moneytracker.app.android.test.SampleDatabase

class MainViewModel: ViewModel() {
    private val _transactions = MutableLiveData<List<TransactionModel>>()
    val transactions: LiveData<List<TransactionModel>> = _transactions

    val addNewItem = MutableEmptyEventLiveData()

    val hello = MutableLiveData<String>()

    init {
        hello.value = "Hello World"
    }

    fun changeText() {
        hello.value = "This is a random text"
        _transactions.value = SampleDatabase.sampleTransactions
    }

    fun addItem() {
        addNewItem.sendEvent()
    }
}