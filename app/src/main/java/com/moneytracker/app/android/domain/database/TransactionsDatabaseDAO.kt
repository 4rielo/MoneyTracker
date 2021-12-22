package com.moneytracker.app.android.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.moneytracker.app.android.domain.model.TransactionEntity

@Dao
interface TransactionsDatabaseDAO {
    @Insert
    fun insert(transaction: TransactionEntity)

    @Update
    fun update(transaction:TransactionEntity)

    @Query ("select * from transactions where transactionId = :key")
    fun get(key: Long): TransactionEntity?

    @Query ("delete from transactions")
    fun clear()

    @Query ("select * from transactions order by transactionId desc")
    fun getAllTransactions(): List<TransactionEntity>
}