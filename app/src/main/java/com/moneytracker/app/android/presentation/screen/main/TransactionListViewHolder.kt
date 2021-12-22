package com.moneytracker.app.android.presentation.screen.main

import androidx.recyclerview.widget.RecyclerView
import com.moneytracker.app.android.databinding.ListItemTransactionsBinding
import com.moneytracker.app.android.domain.model.TransactionModel

class TransactionListViewHolder(private val binding: ListItemTransactionsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(transaction: TransactionModel, onTransactionClicked: (transaction: TransactionModel) -> Unit) {
        binding.apply {
            this.transaction = transaction
            root.setOnClickListener{
                onTransactionClicked(transaction)
            }
            executePendingBindings()
        }
    }
}