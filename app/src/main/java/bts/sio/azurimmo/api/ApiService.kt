package bts.sio.azurimmo.api

import bts.sio.azurimmo.model.Appartement
import bts.sio.azurimmo.model.Batiment
import bts.sio.azurimmo.model.Contrat
import bts.sio.azurimmo.model.Intervention
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("api/batiments/")
    suspend fun getBatiments(): List<Batiment>

    @GET("api/batiments/{id}")
    suspend fun getBatimentById(@Path("id") batimentId: Int): Batiment

    @GET("api/appartements/")
    suspend fun getAppartements(): List<Appartement>

    @GET("api/contrats/")
    suspend fun getContrats(): List<Contrat>

    @GET("api/interventions/")
    suspend fun getInterventions(): List<Intervention>

    @GET("/api/appartements/batiment/{batimentId}")
    suspend fun getAppartementsByBatimentId(@Path("batimentId") batimentId: Int): List<Appartement>

    @POST("api/batiments/")
    suspend fun addBatiment(@Body batiment: Batiment): Response<Batiment>

}
