package com.franco.test.data.repository.source

import com.franco.test.data.Pokemon
import retrofit2.Response

interface RemoteSource {
    suspend fun getList(): Response<List<Pokemon>>
    suspend fun getPockemon(id: String): Response<Pokemon>
}