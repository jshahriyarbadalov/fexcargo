package az.fex.fexcargo.data.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
    @Expose
    @SerializedName("phone")
    val phone: String,
    @Expose
    @SerializedName("filial_id")
    val filialId: String,
    @Expose
    @SerializedName("address")
    val address: String,
)
