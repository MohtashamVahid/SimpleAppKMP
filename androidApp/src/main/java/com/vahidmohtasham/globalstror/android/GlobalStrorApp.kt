package com.vahidmohtasham.globalstror.android

import android.app.Application
import org.koin.core.context.startKoin
import com.vahidmohtasham.globalstror.core.di.appModule

class GlobalStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
