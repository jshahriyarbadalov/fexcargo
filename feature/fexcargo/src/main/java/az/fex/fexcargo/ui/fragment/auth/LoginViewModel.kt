package az.fex.fexcargo.ui.fragment.auth

import az.fex.fexcargo.data.models.request.RegisterRequest
import az.fex.fexcargo.data.models.response.LoginResponse
import az.fex.fexcargo.data.models.response.RegisterResponse
import az.fex.core.base.BaseViewModel
import az.fex.core.extensions.launch
import az.fex.fexcargo.domain.models.request.RegisterReqUI
import kotlinx.coroutines.flow.MutableStateFlow
import az.fex.fexcargo.domain.usecase.auth.LoginUseCase
import az.fex.fexcargo.domain.usecase.auth.RegisterUseCase
import com.bumptech.glide.load.engine.Resource

import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {


    private fun setLogin(email: String, password: String) = launch {

        loginUseCase(
            LoginUseCase.Params(
                email = email,
                password = password
            )
        ).onStart { }
            .catch { }
            .onCompletion { }
    }

    private fun setRegister(register: RegisterReqUI) = launch {
                registerUseCase(
                    RegisterUseCase.Params(
                        register.firstName,
                        register.lastName,
                        register.birthday,
                        register.gender,
                        register.seriaType,
                        register.seriaNumber,
                        register.email,
                        register.provider,
                        register.phone,
                        register.fin,
                        register.filial,
                        register.address,
                        register.password,
                        register.passwordConfirmation
                    )
                ).onStart {  }
                    .catch {  }
                    .onCompletion {  }
    }
}