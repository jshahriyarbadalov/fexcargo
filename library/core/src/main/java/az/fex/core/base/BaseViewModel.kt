package az.fex.core.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.fex.core.extensions.launch
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.e(throwable)
    }

    var shimmerEffect = MutableStateFlow(false)

    var progress = MutableLiveData(false)

    fun showShimmer() = launch {
        shimmerEffect.emit(true)
    }

    fun hideShimmer() = launch {
        shimmerEffect.emit(false)
    }

    fun showProgress() = launch {
        progress.postValue(true)
    }

    fun hideProgress() = launch {
        progress.postValue(false)
    }
}