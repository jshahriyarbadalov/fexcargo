package az.fex.common.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRequest(
    val authToken:String?=null
):Parcelable
