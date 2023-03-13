package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddressesResponse(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name_az")
    val nameAz: String?,
    @Expose
    @SerializedName("origin")
    val origin: String?,
    @Expose
    @SerializedName("code")
    val code: String?,
    @Expose
    @SerializedName("image")
    val image: String?,
    @Expose
    @SerializedName("address")
    val address: Address
)