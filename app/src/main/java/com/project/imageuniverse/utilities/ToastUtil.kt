package com.project.imageuniverse.utilities

import android.widget.Toast
import com.project.imageuniverse.application.ImageUniverseApplication
import com.project.imageuniverse.constants.AppWideConstants.DEFAULT_ERROR_MESSAGE


object ToastUtil {
    private val appContext = ImageUniverseApplication.instance.applicationContext
    fun makeShortToast(message: String?) {
        val errorMessage = message ?: DEFAULT_ERROR_MESSAGE
        Toast.makeText(appContext, errorMessage, Toast.LENGTH_SHORT).show()
    }

    fun makeLongToast(message: String?) {
        val errorMessage = message ?: DEFAULT_ERROR_MESSAGE
        Toast.makeText(appContext, errorMessage, Toast.LENGTH_LONG).show()
    }
}