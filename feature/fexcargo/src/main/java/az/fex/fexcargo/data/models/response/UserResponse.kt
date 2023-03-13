package az.fex.fexcargo.data.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("promo_code")
    val promoCode: Int?,
    @Expose
    @SerializedName("customer_status")
    val customerStatus: Int?,
    @Expose
    @SerializedName("customer_type")
    val customerType: Int?,
    @Expose
    @SerializedName("order_id")
    val orderId: Int?,
    @Expose
    @SerializedName("session_id")
    val sessionId: Int?,
    @Expose
    @SerializedName("referer_id")
    val refererId: Int?,
    @Expose
    @SerializedName("first_name")
    val firstName: String?,
    @Expose
    @SerializedName("last_name")
    val lastName: String?,
    @Expose
    @SerializedName("company_name")
    val companyName: String?,
    @Expose
    @SerializedName("account_number")
    val accountNumber: String?,
    @Expose
    @SerializedName("gender")
    val gender: String?,
    @Expose
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @Expose
    @SerializedName("addresses")
    val addresses: String?,
    @Expose
    @SerializedName("filial_id")
    val filialId: Int?,
    @Expose
    @SerializedName("passport")
    val passport: String?,
    @Expose
    @SerializedName("passport_fin")
    val passportFin: String?,
    @Expose
    @SerializedName("phone")
    val phone: String?,
    @Expose
    @SerializedName("provider")
    val provider: String?,
    @Expose
    @SerializedName("verification_status")
    val verificationStatus: Int?,
    @Expose
    @SerializedName("verification_code")
    val verificationCode: Int?,
    @Expose
    @SerializedName("date")
    val date: String?,
    @Expose
    @SerializedName("email")
    val email: String?,
    @Expose
    @SerializedName("password")
    val password: String?,
    @Expose
    @SerializedName("status")
    val status: Int?,
    @Expose
    @SerializedName("delete")
    val delete: Int?,
    @Expose
    @SerializedName("customer_code")
    val customerCode: Int?,
    @Expose
    @SerializedName("discount")
    val discount: Int?,
    @Expose
    @SerializedName("type")
    val type: Int?,
    @Expose
    @SerializedName("referance_site")
    val referanceSite: String?,
    @Expose
    @SerializedName("remember_token")
    val rememberToken: String?,
    @Expose
    @SerializedName("create_at")
    val createdAt: String?,
    @Expose
    @SerializedName("updated_at")
    val updatedAt: String?,
)