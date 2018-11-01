package com.modic.ignite

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }

}