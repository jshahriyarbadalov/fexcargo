package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NishangahsResponse(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String?,
    @Expose
    @SerializedName("zona_id")
    val zonaId: Int?,
    @Expose
    @SerializedName("customer_type")
    val customerType: Int?,
    @Expose
    @SerializedName("delete")
    val delete: Int?,
    @Expose
    @SerializedName("created_at")
    val createdAt: String?,
    @Expose
    @SerializedName("updated_at")
    val updatedAt: String?,
)
