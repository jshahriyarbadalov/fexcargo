package az.fex.core.utils

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject


class ResProvider @Inject constructor(val context: Context) {
    fun getString(@StringRes id: Int) = context.getString(id)
    fun getDrawable(@DrawableRes id: Int) = ContextCompat.getDrawable(context, id)
    fun getColor(@ColorRes id: Int) = ContextCompat.getColor(context, id)
}