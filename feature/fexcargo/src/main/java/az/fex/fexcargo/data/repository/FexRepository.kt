package az.fex.fexcargo.data.repository

import az.fex.fexcargo.data.models.request.LoginRequest
import az.fex.fexcargo.data.models.request.RegisterRequest
import az.fex.common.models.UserRequest
import az.fex.fexcargo.data.models.response.*
import com.bumptech.glide.load.engine.Resource

import kotlinx.coroutines.flow.Flow


interface FexRepository {

    fun login(login: LoginRequest): Flow<LoginResponse>

    fun register(register: RegisterRequest): Flow<RegisterResponse>

    fun getBranches(): Flow<BranchesResponse>

    fun getUser(userRequest: UserRequest): Flow<UserResponse>

    fun getAddresses(userRequest: UserRequest): Flow<AddressesResponse>
}