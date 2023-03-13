package az.fex.fexcargo.data.repository

import az.fex.fexcargo.data.models.request.LoginRequest
import az.fex.fexcargo.data.models.request.RegisterRequest
import az.fex.common.models.UserRequest
import az.fex.core.base.BaseRepository
import az.fex.core.extensions.toSafeString
import az.fex.fexcargo.data.models.response.*
import az.fex.fexcargo.data.remote.ApiService
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FexRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), FexRepository {
    override fun login(login: LoginRequest): Flow<LoginResponse> =
        sendRequest {
            val result = apiService.login(login)
            result
        }

    override fun register(register: RegisterRequest): Flow<RegisterResponse> {
        return sendRequest {
            val result = apiService.register(register)
          result
        }
    }

    override fun getBranches(): Flow<BranchesResponse>{
        return sendRequest {
            val result = apiService.getBranches()
            result
        }
    }

    override fun getUser(userRequest: UserRequest): Flow<UserResponse> =
        sendRequest {
            val result = apiService.getUser(userRequest.authToken.toSafeString())
            result
        }

    override fun getAddresses(userRequest: UserRequest): Flow<AddressesResponse> {
        return sendRequest {
            val result = apiService.getAddresses(userRequest.authToken.toSafeString())
           result
        }
    }
}