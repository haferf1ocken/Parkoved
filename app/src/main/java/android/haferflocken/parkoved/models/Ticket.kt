package android.haferflocken.parkoved.models

data class Ticket(
    var ticketId: Long = 0L,
    val attraction: String = "",
    val validUntil: String = "",
    val ageRestriction: String = "",
    val workTime: String = "",
    val usage: Int = -1,
    val colorName: String = "",
    val imageUrl: String = ""
)