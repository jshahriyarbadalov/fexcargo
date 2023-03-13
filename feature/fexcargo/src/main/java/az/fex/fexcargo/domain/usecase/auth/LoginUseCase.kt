package az.fex.fexcargo.domain.usecase.auth

import az.fex.core.utils.Mapper
import az.fex.fexcargo.data.models.request.LoginRequest
import az.fex.fexcargo.data.models.response.LoginResponse
import az.fex.core.utils.UseCase
import az.fex.fexcargo.data.repository.FexRepositoryImpl
import az.fex.fexcargo.domain.models.response.LoginRespUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: FexRepositoryImpl
) : UseCase<LoginUseCase.Params, LoginRespUI>() {

    data class Params(
        val email: String,
        val password: String
    )

    override fun execute(params: Params): Flow<LoginRespUI> =
        repository.login(LoginRequest(params.email, params.password)).map { response2UI(it) }

    private fun response2UI(response: LoginResponse): LoginRespUI {
        return object :Mapper<LoginResponse, LoginRespUI>(){
            override fun map(value: LoginResponse): LoginRespUI {
                return LoginRespUI(
                    value.authToken
                )
            }
        }.map(response)
    }
}