package com.moneytracker.app.android.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moneytracker.app.android.R
import com.moneytracker.app.android.databinding.ActivityMainBinding
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.presentation.extensions.getDialog
import com.moneytracker.app.android.presentation.helpers.setContentViewBinding
import com.moneytracker.app.android.presentation.mvvm.observeEvent
import com.moneytracker.app.android.presentation.screen.inputdialog.InputDialogComposable
import com.moneytracker.app.android.presentation.screen.inputdialog.InputDialogFragment
import com.moneytracker.app.android.presentation.util.InputButton
import com.moneytracker.app.android.presentation.util.InputDialogActions
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var transactionListAdapter: TransactionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = mainViewModel.state
            val buttonSpacing = 8.dp
            InputDialogComposable(
                state = state,
                buttonSpacing = buttonSpacing,
                onAction = mainViewModel::onAction,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
                    .padding(16.dp)
            )
        }
        /*binding = setContentViewBinding(R.layout.activity_main,mainViewModel)
        transactionListAdapter = TransactionListAdapter {
            Toast.makeText(this.applicationContext, it.concept, Toast.LENGTH_SHORT).show()
        }
        binding.apply {
            rvTransactionsList.adapter = transactionListAdapter
            ivAddItemButton.setOnClickListener { showAddTransactionDialog() }
        }

        setObservers()*/
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

    @Preview(showBackground = true)
    @Composable
    fun defaultPreview() {
        InputButton("4", Modifier, {})
    }

    private fun showAddTransactionDialog() {

        //InputDialogFragment().dialog
        /*getDialog(R.layout.dialog_add_transaction) {

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

        }*/
    }
}