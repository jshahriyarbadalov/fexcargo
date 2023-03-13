package az.fex.fexcargo.data.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @Expose
    @SerializedName("first_name")
    val firstName: String?,
    @Expose
    @SerializedName("last_name")
    val lastName: String?,
    @Expose
    @SerializedName("birthday")
    val birthday: String?,
    @Expose
    @SerializedName("gender")
    val gender: String?,
    @Expose
    @SerializedName("seriatype")
    val seriaType: String?,
    @Expose
    @SerializedName("serianumber")
    val seriaNumber: String?,
    @Expose
    @SerializedName("email")
    val email: String?,
    @Expose
    @SerializedName("provider")
    val provider: String?,
    @Expose
    @SerializedName("phone")
    val phone: String?,
    @Expose
    @SerializedName("fin")
    val fin: String?,
    @Expose
    @SerializedName("filial")
    val filial: String?,
    @Expose
    @SerializedName("address")
    val address: String?,
    @Expose
    @SerializedName("password")
    val password: String?,
    @Expose
    @SerializedName("password_confirmation")
    val passwordConfirmation: String?
)