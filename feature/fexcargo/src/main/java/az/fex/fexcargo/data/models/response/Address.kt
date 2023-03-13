package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Address(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("country_id")
    val countryId: Int,
    @Expose
    @SerializedName("city_id")
    val cityId: Int,
    @Expose
    @SerializedName("first_name")
    val firstName: String?,
    @Expose
    @SerializedName("last_name")
    val lastName: String?,
    @Expose
    @SerializedName("address_line_1")
    val addressLineOne: String?,
    @Expose
    @SerializedName("address_line_2")
    val addressLineTwo: String?,
    @Expose
    @SerializedName("text_az")
    val textAz: String?,
    @Expose
    @SerializedName("phone")
    val phone: String?,
    @Expose
    @SerializedName("index")
    val index: String?,
    @Expose
    @SerializedName("district")
    val district: String?,
    @Expose
    @SerializedName("province")
    val province: String?,
    @Expose
    @SerializedName("passport_fin")
    val passportFin: String?,
    @Expose
    @SerializedName("receiver")
    val receiver: String?,
    @Expose
    @SerializedName("city_name")
    val cityName: CityName?,
)