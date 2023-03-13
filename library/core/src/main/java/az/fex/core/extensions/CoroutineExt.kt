package az.fex.core.extensions

import androidx.lifecycle.viewModelScope
import az.fex.core.base.BaseViewModel

import kotlinx.coroutines.*

fun BaseViewModel.launch(block: suspend CoroutineScope.() -> Unit): Job {
    return viewModelScope.launch(exceptionHandler, CoroutineStart.DEFAULT, block)
}

fun BaseViewModel.launchOnUI(block: suspend CoroutineScope.() -> Unit): Job {
    return viewModelScope.launch(Dispatchers.IO, CoroutineStart.DEFAULT, block)
}