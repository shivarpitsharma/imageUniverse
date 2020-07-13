package com.project.imageuniverse.application

import android.app.Application

/**
 * Created by Shivarpit
 */
class ImageUniverseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ImageUniverseApplication
            private set
    }
}