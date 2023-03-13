package az.fex.core.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.annotation.MainThread
import az.fex.core.base.BaseFragment
import az.fex.core.base.BaseViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel

@MainThread
inline fun <reified VM : BaseViewModel> BaseFragment<*>.injectVm(): Lazy<VM> {
    return viewModel<VM>().also {
        it.bindingListener(this)
        it.viewListener(this)
    }
}

fun Activity.hideKeyboard() {
    val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    im.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}