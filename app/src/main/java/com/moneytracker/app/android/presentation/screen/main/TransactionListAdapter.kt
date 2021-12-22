package com.moneytracker.app.android.presentation.screen.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.moneytracker.app.android.R
import com.moneytracker.app.android.databinding.ListItemTransactionsBinding
import com.moneytracker.app.android.domain.model.TransactionModel

class TransactionListAdapter(private val onItemSelected: (itemSelected: TransactionModel) -> Unit): RecyclerView.Adapter<TransactionListViewHolder>() {
    private var transactionList: List<TransactionModel> = emptyList<TransactionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionListViewHolder {
        val binding: ListItemTransactionsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_transactions,
            parent,
            false
        )
        return TransactionListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        holder.bind(transactionList[position], onTransactionClicked = onItemSelected)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    fun swapData(newList: List<TransactionModel>) {
        transactionList = newList
        notifyDataSetChanged()
    }
}