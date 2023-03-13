package az.fex.fexcargo.di


import az.fex.core.base.BaseViewModel
import az.fex.fexcargo.ui.fragment.auth.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule {
    val vm: Module = module {
        viewModel<BaseViewModel>()
        viewModel { LoginViewModel(get(), get()) }
    }
}