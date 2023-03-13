package com.onurcankeskin.core.extension

inline fun <T : Any, R : Any> safeWith(value: T?, block: T.() -> R): R? {
    return if (value != null) {
        block(value)
    } else {
        null
    }
}

fun <T> List<T>?.toSafeList(): List<T> {
    return if (this.isNullOrEmpty()) emptyList() else this
}
