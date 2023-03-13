package com.onurcankeskin.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit): Unit =
    liveData.observe(this) { t -> body(t) }