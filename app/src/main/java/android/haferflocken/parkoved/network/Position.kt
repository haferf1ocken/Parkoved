package android.haferflocken.parkoved.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Position(
    val lat: Double,
    val lon: Double
)