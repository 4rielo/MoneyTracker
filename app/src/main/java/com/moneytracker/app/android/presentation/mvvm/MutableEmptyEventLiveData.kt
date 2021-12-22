package com.moneytracker.app.android.presentation.mvvm

class MutableEmptyEventLiveData : MutableEventLiveData<Unit>() {
    fun sendEvent() {
        value = Event.EMPTY
    }
}