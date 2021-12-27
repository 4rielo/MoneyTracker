package com.moneytracker.app.android.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moneytracker.app.android.domain.model.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 2, exportSchema = false)
abstract class TransactionsDatabase: RoomDatabase() {
    abstract val transactionsDatabaseDAO: TransactionsDatabaseDAO

    /*companion object {
        @Volatile
        private var INSTANCE: TransactionsDatabase? = null

        fun getDatabase(context: Context): TransactionsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TransactionsDatabase::class.java,
                        "transactions_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }*/
}