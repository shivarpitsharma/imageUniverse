package com.project.imageuniverse.utilities

import android.view.View

/**
 * Created by Shivarpit
 */

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.showHide(show: Boolean) {
    if (show) {
        this.show()
    } else {
        this.hide()
    }
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}