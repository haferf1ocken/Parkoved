package android.haferflocken.parkoved.database

import android.haferflocken.parkoved.network.Position
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseService(
    @PrimaryKey
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
    @ColumnInfo(name = "position")
    val position: Position
)