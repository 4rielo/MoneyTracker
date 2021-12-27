package com.moneytracker.app.android.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val transactionId: Int? = null,

    @ColumnInfo(name = "amount")
    var amount: Float? = null,

    @ColumnInfo(name = "concept")
    var concept: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "number_of_quotes")
    var numberOfQuotes: Int? = null,

    @ColumnInfo(name = "current_quote")
    var currentQuote: Int? = null,

    @ColumnInfo(name = "category")
    var category: String? = null,

    @ColumnInfo(name = "note")
    var note: String? = null,

    @ColumnInfo(name = "payment_method")
    var paymentMethod: String? = null,

    @ColumnInfo(name = "location")
    var location: String? = null,

    @ColumnInfo(name = "attached_files")
    var attachedFiles: String? = null,
)
