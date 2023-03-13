package az.fex.fexcargo.domain.models.request


data class RegisterReqUI(
    val firstName: String?,
    val lastName: String?,
    val birthday: String?,
    val gender: String?,
    val seriaType: String?,
    val seriaNumber: String?,
    val email: String?,
    val provider: String?,
    val phone: String?,
    val fin: String?,
    val filial: String?,
    val address: String?,
    val password: String?,
    val passwordConfirmation: String?
)