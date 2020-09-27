package android.haferflocken.parkoved.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTicket(
    val tid: String,
    val service: String,
    val uses: Int,
    val isForChild: Boolean,
    val owner: String,
    val expiresAt: Int,
    val createdAt: Int
)