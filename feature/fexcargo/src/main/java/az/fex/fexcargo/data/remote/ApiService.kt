package az.fex.fexcargo.data.remote

import az.fex.fexcargo.data.models.request.LoginRequest
import az.fex.fexcargo.data.models.request.NewStatementRequest
import az.fex.fexcargo.data.models.request.RegisterRequest
import az.fex.fexcargo.data.models.request.UpdatePasswordRequest
import az.fex.fexcargo.data.models.request.UpdateUserRequest
import az.fex.fexcargo.data.models.response.*
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(@Body login: LoginRequest): LoginResponse

    @POST("register")
    suspend fun register(@Body login: RegisterRequest): RegisterResponse

    @POST("update/user")
    suspend fun updateUser(@Body updateUser: UpdateUserRequest): UpdateUserResponse

    @POST("/update/user/password")
    suspend fun updateUserPassword(@Body updatePass: UpdatePasswordRequest): UpdatePasswordResponse

    @POST("new-statement")
    suspend fun newStatement(@Body request: NewStatementRequest)

    @GET("branches")
    suspend fun getBranches(): BranchesResponse

    @GET("user")
    @Headers("Content-type: application/json;")
    suspend fun getUser(@Header("Authorization") authToken: String): UserResponse

    @GET("addresses")
    @Headers("Content-type: application/json;")
    suspend fun getAddresses(@Header("Authorization") authToken: String): AddressesResponse

    @GET("nishangahs")
    suspend fun getNishangahs(): NishangahsResponse




}