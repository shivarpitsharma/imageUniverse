package com.project.imageuniverse.application

import android.app.Application


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