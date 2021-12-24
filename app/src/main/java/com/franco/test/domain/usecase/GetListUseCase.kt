package com.franco.test.domain.usecase

import com.franco.test.data.model.Pokemon
import com.franco.test.data.util.Resource
import com.franco.test.domain.repository.PockeRepository

class GetListUseCase(
    private val pockeRepository: PockeRepository
) {
    suspend fun execute(): Resource<List<Pokemon>> {
        return pockeRepository.getList()
    }
}