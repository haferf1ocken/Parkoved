package android.haferflocken.parkoved.extensions

import android.haferflocken.parkoved.database.DatabaseTicket
import android.haferflocken.parkoved.network.NetworkTicket

fun List<NetworkTicket>.asDataBaseModel(): Array<DatabaseTicket> {
    return this.map {
        DatabaseTicket (
            tid= it.tid,
            service= it.service,
            uses= it.uses,
            isForChild= it.isForChild,
            owner= it.owner,
            expiresAt= it.expiresAt,
            createdAt= it.createdAt
        )
    }.toTypedArray()
}