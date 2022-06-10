package com.gaur.data.network

import com.gaur.common.AppConstant
import com.gaur.data.model.MatchDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/venues/search")
    suspend fun getAllMatches(
        @Query("ll") ll:String = AppConstant.SEARCH,
        @Query("oauth_token") token:String = AppConstant.API_KEY,
        @Query("v") v:String = "20180616"
    ):Response<MatchDTO>


}