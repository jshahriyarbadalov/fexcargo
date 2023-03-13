package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BranchesResponse(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String?
)