package android.haferflocken.parkoved.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseTicket(
    @PrimaryKey
    val tid: String,
    val service: String,
    val uses: Int,
    val isForChild: Boolean,
    val owner: String,
    val expiresAt: Int,
    val createdAt: Int,
)