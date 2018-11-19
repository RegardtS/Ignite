package com.modic.ignite

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true

        AppCenter.start(this, "b7e37712-9f4e-458a-a400-69ea86f6f175",Analytics::class.java, Crashes::class.java)
    }
}