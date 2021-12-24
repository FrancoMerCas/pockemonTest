package com.franco.test.data.api

import com.franco.test.data.Pokemon
import retrofit2.http.GET

interface APIService {
    @GET()
    suspend fun getListPockemon(): List<Pokemon>

    @GET()
    suspend fun getPockemonInfor(): Pokemon
}