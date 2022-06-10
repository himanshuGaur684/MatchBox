package com.gaur.domain.use_cases

import com.gaur.common.Resource
import com.gaur.domain.model.Venue
import com.gaur.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetAllVenuesUseCase(private val matchRepository: MatchRepository) {

    operator fun invoke() : Flow<Resource<List<Venue>>> = flow{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = matchRepository.getAllVenues()))
        }catch (e: Exception){
            emit(Resource.Error(message =  e.message.toString()))
        }
    }

}