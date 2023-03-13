package az.fex.core.extensions

import az.fex.core.utils.GsonProvider
import com.google.gson.reflect.TypeToken

fun String?.toSafeString(): String {
    return if (this.isNullOrBlank() || this == "null") {
        ""
    } else this
}

inline fun <reified T> String.toModel(): T =
    GsonProvider.gson.fromJson(this, object : TypeToken<T>() {}.type)