package android.haferflocken.parkoved.network

import android.haferflocken.parkoved.models.Ticket
import android.haferflocken.parkoved.models.User
import retrofit2.http.GET
import retrofit2.http.POST

interface ParkovedServiceApi {

    @POST("api/auth/request")
    suspend fun authRequest(): String

    @POST("api/auth/confirm")
    suspend fun authConfirm(): String

    @POST("api/auth/admin")
    suspend fun authAdmin(): List<String>

    @POST("api/tickets")
    suspend fun sendTicketInfo()

    @GET("api/users/me")
    suspend fun getUser(): User

    @GET("api/tickets")
    suspend fun getTickets(): List<Ticket>
}