package com.franco.test.domain.repository

import com.franco.test.data.model.Pokemon
import com.franco.test.data.util.Resource

interface PockeRepository {
    suspend fun getList(): Resource<List<Pokemon>>
    suspend fun getPockemon(id: String): Resource<Pokemon>
}