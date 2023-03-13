package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdatePasswordResponse(
    @SerializedName("success-message")
    @Expose
    val successMessage: String
)
