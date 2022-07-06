package com.moneytracker.app.android.domain.model

import androidx.room.*

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    var transactionId: Long = 0,

    @ColumnInfo(name = "amount")
    var amount: Float? = null,

    @ColumnInfo(name = "concept")
    var concept: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "number_of_payments")
    var numberOfPayments: Int? = null,

    @ColumnInfo(name = "current_payment")
    var currentPayment: Int? = null,

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
