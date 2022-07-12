package com.moneytracker.app.android.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.moneytracker.app.android.databinding.ActivityMainBinding
import com.moneytracker.app.android.presentation.mvvm.observeEvent
import com.moneytracker.app.android.presentation.screen.inputdialog.InputDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var transactionListAdapter: TransactionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        transactionListAdapter = TransactionListAdapter {
            Toast.makeText(this.applicationContext, it.concept, Toast.LENGTH_SHORT).show()
        }
        binding.apply {
            viewModel = mainViewModel
            rvTransactionsList.adapter = transactionListAdapter
            //ivAddItemButton.setOnClickListener { showAddTransactionDialog() }
        }

        setContentView(binding.root)
        setObservers()
    }

    private fun setObservers() {
        observeDatabase()
        observeAddNewItem()
    }

    private fun observeDatabase() {
        mainViewModel.transactions.observe(this){
            transactionListAdapter.swapData(it)
        }
    }

    private fun observeAddNewItem(){
        mainViewModel.addNewItem.observeEvent(this){
            val dialogFragment = InputDialogFragment.newInstance(this)
            dialogFragment.show(supportFragmentManager,null)
        }
    }

    private fun showAddTransactionDialog() {

    }
}