package com.moneytracker.app.android.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.domain.model.TransactionEntityConverter

@Database(entities = [TransactionEntity::class], version = 3, exportSchema = false)
@TypeConverters(TransactionEntityConverter::class)
abstract class TransactionsDatabase: RoomDatabase() {
    abstract fun transactionsDatabaseDAO(): TransactionsDatabaseDAO
}