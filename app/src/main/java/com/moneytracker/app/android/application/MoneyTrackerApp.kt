package com.moneytracker.app.android.application

import android.app.Application
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.moneytracker.app.android.application.di.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoneyTrackerApp: Application() {

    companion object {
        internal const val MY_REQUEST_CODE: Int = 1
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoneyTrackerApp)
            modules(appModules)
        }
    }
}