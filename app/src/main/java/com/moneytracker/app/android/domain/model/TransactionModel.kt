package com.moneytracker.app.android.domain.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(
    val transactionId: Int? = null,
    var amount: Float? = null,
    var concept: String? = null,
    var date: String? = null,
    @SerializedName("number_of_payments") var numberOfPayments: Int? = null,
    @SerializedName("current_payment") var currentPayment: Int? = null,
    var category: String? = null,
    var note: String? = null,
    @SerializedName("payment_method") var paymentMethod: String? = null,
    var location: String? = null,
    @SerializedName("attached_files") var attachedFiles: List<String>? = null,
)
