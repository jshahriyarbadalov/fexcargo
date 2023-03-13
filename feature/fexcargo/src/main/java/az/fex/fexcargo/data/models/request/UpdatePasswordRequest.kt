package az.fex.fexcargo.data.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdatePasswordRequest(
    @Expose
    @SerializedName("password")
    val password: String?,
    @Expose
    @SerializedName("password_confirmation")
    val passwordConfirm: String?
)
