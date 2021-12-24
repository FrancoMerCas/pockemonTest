package com.franco.test.data.repository.sourceImpl

import com.franco.test.data.Pokemon
import com.franco.test.data.repository.source.RemoteSource
import retrofit2.Response

class RemoteSourceImpl: RemoteSource {
    override suspend fun getList(): Response<List<Pokemon>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPockemon(id: String): Response<Pokemon> {
        TODO("Not yet implemented")
    }
}