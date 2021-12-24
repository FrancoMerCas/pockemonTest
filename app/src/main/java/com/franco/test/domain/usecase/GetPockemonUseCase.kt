package com.franco.test.domain.usecase

import com.franco.test.data.model.Pokemon
import com.franco.test.data.util.Resource
import com.franco.test.domain.repository.PockeRepository

class GetPockemonUseCase(
    private val pockeRepository: PockeRepository
) {
    suspend fun execute(id: String): Resource<Pokemon> {
        return pockeRepository.getPockemon(id)
    }
}