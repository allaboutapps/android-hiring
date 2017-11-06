package at.allaboutapps.a3hiring.api.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(val name: String,
                val country: String,
                val value: Long,
                val image: String?) : Parcelable