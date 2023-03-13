package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityName (
    @Expose
    @SerializedName("id")
    val id:Int,
    @Expose
    @SerializedName("name_az")
    val NameAz:String?,
)