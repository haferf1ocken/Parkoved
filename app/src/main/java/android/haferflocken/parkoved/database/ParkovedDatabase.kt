package android.haferflocken.parkoved.database

import android.content.Context
import android.haferflocken.parkoved.models.Ticket
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ticket::class], version = 1)
abstract class ParkovedDatabase: RoomDatabase() {
    abstract val ticketDao: TicketDao
    //abstract val serviceDao: ServiceDao
    companion object {
        @Volatile
        private lateinit var INSTANCE: ParkovedDatabase

        fun getDatabase(context: Context) : ParkovedDatabase {
            synchronized(ParkovedDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ParkovedDatabase::class.java,
                        "tables").build()
                }
            }
            return INSTANCE
        }
    }
}