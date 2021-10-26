package com.example.apiretrofit


import android.app.Application
import dataModul
import viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules =  listOf(dataModul,viewModelModule)
        startKoin { androidLogger()

            androidContext(this@App)

            androidFileProperties()

            koin.loadModules(modules)
        }
    }
}