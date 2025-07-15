package com.vahidmohtasham.globalstror.android

import android.app.Application
import com.vahidmohtasham.globalstror.android.core.di.androidModule
import com.vahidmohtasham.globalstror.core.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GlobalStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GlobalStoreApp)
            modules(sharedModule, androidModule)
        }

    }
}
