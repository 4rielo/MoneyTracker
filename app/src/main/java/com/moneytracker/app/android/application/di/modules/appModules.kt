package com.moneytracker.app.android.application.di.modules

import android.app.Application
import androidx.room.Room
import com.moneytracker.app.android.domain.database.TransactionsDatabase
import com.moneytracker.app.android.domain.database.TransactionsDatabaseDAO
import com.moneytracker.app.android.presentation.screen.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}

val dabataseModule = module {
    fun provideDataBase(application: Application): TransactionsDatabase {
        return Room.databaseBuilder(
                application,
                TransactionsDatabase::class.java,
                "TransactionsDataBase")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDAO(dataBase: TransactionsDatabase): TransactionsDatabaseDAO {
        return dataBase.transactionsDatabaseDAO
    }

    single { provideDataBase(androidApplication()) }
    single { provideDAO(get()) }
}

val appModules = listOf(
    dabataseModule,
    appModule,
)
