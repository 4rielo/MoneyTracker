package com.moneytracker.app.android.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.moneytracker.app.android.R
import com.moneytracker.app.android.databinding.ActivityMainBinding
import com.moneytracker.app.android.presentation.helpers.setContentViewBinding
import com.moneytracker.app.android.presentation.mvvm.observeEvent
import com.moneytracker.app.android.test.SampleDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var transactionListAdapter: TransactionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = setContentViewBinding(R.layout.activity_main,mainViewModel)
        transactionListAdapter = TransactionListAdapter {
            Toast.makeText(this.applicationContext, it.concept, Toast.LENGTH_SHORT).show()
        }
        binding.rvTransactionsList.adapter = transactionListAdapter
        setObservers()
    }

    private fun setObservers() {
        observeHello()
        observeDatabase()
        observeAddNewItem()
    }

    private fun observeHello(){
        mainViewModel.hello.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun observeDatabase() {
        mainViewModel.transactions.observe(this){
            transactionListAdapter.swapData(it)
        }
    }

    private fun observeAddNewItem(){
        mainViewModel.addNewItem.observeEvent(this){

        }
    }
}