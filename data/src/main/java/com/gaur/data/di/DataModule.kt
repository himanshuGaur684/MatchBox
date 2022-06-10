package com.gaur.data.di

import android.content.Context
import com.gaur.common.AppConstant
import com.gaur.data.network.ApiService
import com.gaur.data.reptository.MatchRepositoryImpl
import com.gaur.data.room.MatchDAO
import com.gaur.data.room.MatchDatabase
import com.gaur.domain.repository.MatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(AppConstant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Singleton
    @Provides
    fun getMatchDatabase(@ApplicationContext context:Context):MatchDatabase{
        return MatchDatabase.getInstance(context)
    }


    @Singleton
    @Provides
    fun getMatchDAO(matchDatabase: MatchDatabase):MatchDAO{
        return matchDatabase.getMatchDAO()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun provideMatchRepo(apiService: ApiService,matchDAO: MatchDAO):MatchRepository{
        return MatchRepositoryImpl(apiService, matchDAO)
    }

}