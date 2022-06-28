package com.moneytracker.app.android.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.moneytracker.app.android.R
import com.moneytracker.app.android.application.MoneyTrackerApp
import com.moneytracker.app.android.databinding.ActivityMainBinding
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.presentation.extensions.getDialog
import com.moneytracker.app.android.presentation.helpers.setContentViewBinding
import com.moneytracker.app.android.presentation.mvvm.observeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var transactionListAdapter: TransactionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = setContentViewBinding(R.layout.activity_main,mainViewModel)
        transactionListAdapter = TransactionListAdapter {
            Toast.makeText(this.applicationContext, it.concept, Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            rvTransactionsList.adapter = transactionListAdapter
            ivAddItemButton.setOnClickListener { showAddTransactionDialog() }
        }

        val appUpdateManager = AppUpdateManagerFactory.create(baseContext)

// Returns an intent object that you use to check for an update.
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                // This example applies an immediate update. To apply a flexible update
                // instead, pass in AppUpdateType.FLEXIBLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                // Request the update.
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    AppUpdateType.IMMEDIATE,
                    this,
                    MoneyTrackerApp.MY_REQUEST_CODE
                )
            }
        }

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

    private fun showAddTransactionDialog() {

        getDialog(R.layout.dialog_add_transaction) {

            /*val btnOne = findViewById<AppCompatButton>(R.id.btnOne)
            val btnTwo = findViewById<AppCompatButton>(R.id.btnTwo)
            val btnThree = findViewById<AppCompatButton>(R.id.btnThree)
            val btnFour = findViewById<AppCompatButton>(R.id.btnFour)
            val btnFive = findViewById<AppCompatButton>(R.id.btnFive)
            val btnSix = findViewById<AppCompatButton>(R.id.btnSix)
            val btnSeven = findViewById<AppCompatButton>(R.id.btnSeven)
            val btnEight = findViewById<AppCompatButton>(R.id.btnEight)
            val btnNine = findViewById<AppCompatButton>(R.id.btnNine)
            val btnDot = findViewById<AppCompatButton>(R.id.btnDot)
            val btnZero = findViewById<AppCompatButton>(R.id.btnZero)
            val btnBack = findViewById<AppCompatButton>(R.id.btnBack)*/
            val amount = findViewById<AppCompatEditText>(R.id.etAmount)
            val concept = findViewById<AppCompatEditText>(R.id.etConcept)
            val btnClose = findViewById<AppCompatImageButton>(R.id.btnClose)
            val btnSave = findViewById<AppCompatButton>(R.id.btnSave)
            btnClose.setOnClickListener { dismiss() }
            btnSave.setOnClickListener {
                val newTransaction: TransactionEntity = TransactionEntity(amount = amount.text.toString().toFloatOrNull(), concept = concept.text.toString())
                mainViewModel.storeNewTransaction(newTransaction)
                dismiss()
            }

            //btnOne.setOnClickListener {  }

        }
    }
}