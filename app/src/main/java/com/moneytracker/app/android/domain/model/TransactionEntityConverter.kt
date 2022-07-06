package com.moneytracker.app.android.domain.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class TransactionEntityConverter {
    @TypeConverter
    fun fromJsonString(srtJson: String): TransactionEntity? {
        return Gson().fromJson(srtJson, TransactionEntity::class.java)
    }

    @TypeConverter
    fun toJsonString(data: TransactionEntity): String {
        return Gson().toJson(data)
    }
}