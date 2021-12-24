package com.franco.test.data.repository

import com.franco.test.data.model.Pokemon
import com.franco.test.data.repository.source.RemoteSource
import com.franco.test.data.util.Resource
import com.franco.test.domain.repository.PockeRepository
import retrofit2.Response

class PockeRepositoryImpl(
    private val remoteSource: RemoteSource
): PockeRepository {

    override suspend fun getList(): Resource<List<Pokemon>> = responseToRemoteResourceList(remoteSource.getList())

    override suspend fun getPockemon(id: String): Resource<Pokemon> = responseToRemoteResource(remoteSource.getPockemon(id))

    private fun responseToRemoteResourceList(response : Response<List<Pokemon>>) : Resource<List<Pokemon>> {
        if(response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToRemoteResource(response : Response<Pokemon>) : Resource<Pokemon> {
        if(response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}