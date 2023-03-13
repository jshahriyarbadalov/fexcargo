package az.fex.core.extensions

import androidx.lifecycle.lifecycleScope
import az.fex.core.base.BaseFragment
import az.fex.core.base.BaseViewModel
import com.onurcankeskin.core.extension.observe

inline fun <reified VM : BaseViewModel> Lazy<VM>.bindingListener(owner: BaseFragment<*>) {
    with(owner) {
        lifecycleScope.launchWhenResumed {
            value.let { vm ->
                vi.lifecycleOwner = owner
                //   vi.setVariable(BR.viewModel, vm)
                vi.executePendingBindings()
            }
        }
    }
}

inline fun <reified VM : BaseViewModel> Lazy<VM>.viewListener(owner: BaseFragment<*>) {
    with(owner) {
        lifecycleScope.launchWhenCreated {
            this@viewListener.value.let { vm ->
                lifecycleScope.launchWhenCreated {
                    vm.shimmerEffect.collect {
                        vm.showShimmer()
                    }
                }
                observe(vm.progress) {
                    vm.showProgress()
                }
            }
        }
    }
}