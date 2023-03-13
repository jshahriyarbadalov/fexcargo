package az.fex.fexcargo.domain.usecase.auth

import az.fex.core.utils.Mapper
import az.fex.core.utils.UseCase
import az.fex.fexcargo.data.models.request.RegisterRequest
import az.fex.fexcargo.data.models.response.LoginResponse
import az.fex.fexcargo.data.models.response.RegisterResponse
import az.fex.fexcargo.data.repository.FexRepositoryImpl
import az.fex.fexcargo.domain.models.request.RegisterReqUI
import az.fex.fexcargo.domain.models.response.LoginRespUI
import az.fex.fexcargo.domain.models.response.RegisterRespUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: FexRepositoryImpl
) : UseCase<RegisterUseCase.Params, RegisterRespUI>() {

    data class Params(
        val firstName: String?,
        val lastName: String?,
        val birthday: String?,
        val gender: String?,
        val seriaType: String?,
        val seriaNumber: String?,
        val email: String?,
        val provider: String?,
        val phone: String?,
        val fin: String?,
        val filial: String?,
        val address: String?,
        val password: String?,
        val passwordConfirmation: String?
    )

    override fun execute(params: Params): Flow<RegisterRespUI> {
      return repository.register(RegisterRequest(
           firstName = params.firstName,
           lastName = params.lastName,
           birthday = params.birthday,
           gender = params.gender,
           seriaType = params.seriaType,
           seriaNumber = params.seriaNumber,
           email = params.email,
           provider = params.provider,
           phone = params.phone,
           fin = params.fin,
           filial = params.filial,
           address = params.address,
           password = params.password,
           passwordConfirmation = params.passwordConfirmation
       )).map { response2UI(it) }
    }

    private fun response2UI(response: RegisterResponse): RegisterRespUI {
        return object : Mapper<RegisterResponse, RegisterRespUI>(){
            override fun map(value: RegisterResponse): RegisterRespUI {
                return RegisterRespUI(
                    value.authToken
                )
            }
        }.map(response)
    }

}