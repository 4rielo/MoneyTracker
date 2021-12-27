package com.moneytracker.app.android.application

import android.app.Application
import com.moneytracker.app.android.application.di.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoneyTrackerApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoneyTrackerApp)
            modules(appModules)
        }
    }
}