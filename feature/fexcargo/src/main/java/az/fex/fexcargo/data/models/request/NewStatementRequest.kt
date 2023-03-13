package az.fex.fexcargo.data.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewStatementRequest(
    @Expose
    @SerializedName("currency_id")
    val currencyId: Int,
    @Expose
    @SerializedName("tracking_code_magazine")
    val trackingCodeMagazine: String,
    @Expose
    @SerializedName("shop")
    val shop: Int,
    @Expose
    @SerializedName("category_id")
    val categoryId: Int,
    @Expose
    @SerializedName("price")
    val price: Double,
    @Expose
    @SerializedName("quantity")
    val quantity: String,
    @Expose
    @SerializedName("text")
    val text: String,
    @Expose
    @SerializedName("check")
    val check: Int?,
    @Expose
    @SerializedName("box")
    val box: Int,
    @Expose
    @SerializedName("battery")
    val battery: Int?,
    @Expose
    @SerializedName("attachement")
    val attachement: String,
    @Expose
    @SerializedName("terms")
    val terms: String,
)
