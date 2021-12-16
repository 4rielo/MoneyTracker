package com.mymalls.app.moneytracker.domain.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(
    val ammount: Float? = null,
    val concept: String? = null,
    val date: String? = null,
    @SerializedName("number_of_quotes") val numberOfQuotes: Int? = null,
    @SerializedName("current_quote") val currentQuote: Int? = null,
    val category: String? = null,
    val note: String? = null,
    @SerializedName("payment_method") val paymentMethod: String? = null,
    val location: String? = null,
    @SerializedName("attached_files") val attachedFiles: List<String>? = null,
)
