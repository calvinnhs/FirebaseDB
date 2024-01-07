package com.example.firebasedb

import android.app.Application
import com.example.firebasedb.data.AppContainer
import com.example.firebasedb.data.kontakContainer

class KontakAplication : Application(){

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = kontakContainer()
    }
}