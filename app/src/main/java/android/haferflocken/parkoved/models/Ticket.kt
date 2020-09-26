package android.haferflocken.parkoved.models

data class Ticket(
    var tid: String? = null,
    val service: String? = null,
    val uses: Int? = null,
    val isForChild: Boolean? = null,

    val ageRestriction: String = "",
    val expiresAt: Int = -1,
    val imageUrl: String = ""
)