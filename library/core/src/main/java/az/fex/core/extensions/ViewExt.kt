package com.onurcankeskin.core.extension

import android.view.View

fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.setVisible(b: Boolean) {
    if (b)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}

fun View.expandView() {
    val isViewVisible = when (this.visibility) {
        View.VISIBLE -> true
        else -> false
    }
    if (isViewVisible) {
        setVisible(false)
    } else {
        setVisible(true)
    }
}
