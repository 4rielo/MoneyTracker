package com.mymalls.app.moneytracker.presentation.screen.main

import android.R
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mymalls.app.moneytracker.domain.model.TransactionModel
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    private val _transactions = MutableLiveData<List<TransactionModel>>()

    val hello = MutableLiveData<String>()

    init {
        hello.value = "Hello World"
    }

    fun changeText() {
        hello.value = "This is a random text"
    }
}