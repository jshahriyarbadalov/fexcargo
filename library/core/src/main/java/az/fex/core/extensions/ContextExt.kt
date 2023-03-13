package az.fex.core.extensions

import android.R
import android.app.Activity
import android.content.Context
import android.view.WindowManager
import androidx.annotation.StyleRes

inline fun <reified T> Context.getJson(file: Int): T {
    val input = resources.openRawResource(file)

    val b = ByteArray(input.available())
    input.read(b)

    return String(b).toModel()
}

fun Activity?.updateStatusBarColor(@StyleRes theme: Int?) {
    theme?.let {
        val attr = intArrayOf(R.attr.statusBarColor)
        val styleAttr = this?.obtainStyledAttributes(theme, attr)
        this?.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = styleAttr?.getColor(0, -1) ?: -1
        }
        styleAttr?.recycle()
    }
}


