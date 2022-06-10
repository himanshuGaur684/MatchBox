package com.gaur.domain.di

import com.gaur.domain.repository.MatchRepository
import com.gaur.domain.use_cases.DeleteVenueUseCase
import com.gaur.domain.use_cases.GetAllLocalVenuesUseCase
import com.gaur.domain.use_cases.GetAllVenuesUseCase
import com.gaur.domain.use_cases.InsertVenueUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    fun provideDeleteUseCase(matchRepository: MatchRepository):DeleteVenueUseCase{
        return DeleteVenueUseCase(matchRepository)
    }

    @Provides
    fun provideAllVenues(matchRepository: MatchRepository):GetAllVenuesUseCase{
        return GetAllVenuesUseCase(matchRepository)
    }

    @Provides
    fun provideAllVenuesLocally(matchRepository: MatchRepository):GetAllLocalVenuesUseCase{
        return GetAllLocalVenuesUseCase(matchRepository)
    }

    @Provides
    fun insertVenueUseCase(matchRepository: MatchRepository):InsertVenueUseCase{
        return InsertVenueUseCase(matchRepository)
    }


}