package com.moneytracker.app.android.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.moneytracker.app.android.domain.model.TransactionEntity

@Dao
interface TransactionsDatabaseDAO {
    @Insert
    suspend fun insert(transaction: TransactionEntity)

    @Update
    suspend fun update(transaction:TransactionEntity)

    @Query ("SELECT * FROM transactions WHERE transactionId = :key")
    suspend fun get(key: Long): TransactionEntity?

    @Query ("delete from transactions")
    suspend fun clear()

    @Query ("SELECT * FROM transactions ORDER BY transactionId DESC")
    suspend fun getAllTransactions(): List<TransactionEntity>
}