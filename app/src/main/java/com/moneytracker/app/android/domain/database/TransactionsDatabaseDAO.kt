package com.moneytracker.app.android.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.moneytracker.app.android.domain.model.TransactionEntity
import com.moneytracker.app.android.domain.model.TransactionModel

@Dao
interface TransactionsDatabaseDAO {
    @Insert
    fun insert(transaction: TransactionEntity)

    @Update
    fun update(transaction: TransactionEntity)

    @Query ("SELECT * FROM transactions WHERE transactionId = :id")
    fun getTransaction(id: Long): TransactionEntity?

    @Query ("DELETE FROM transactions")
    fun clearAll()

    @Query ("SELECT * FROM transactions ORDER BY transactionId DESC")
    fun getAllTransactions(): List<TransactionEntity>
}