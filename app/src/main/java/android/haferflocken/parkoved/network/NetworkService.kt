package android.haferflocken.parkoved.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkService(
    val sid: String,
    val park: String,
    val kind: String,
    val name: String,
    val expireTime: Int,
    val workingHours: String,
    val ageLimit: Int,
    val priceAdults: Int,
    val priceChildren: Int,
    val pictures: String,
    val desc: String,
    val longDesc: String,
    val position: Position
)