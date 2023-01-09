package com.example.filimosearch.data.api

import com.example.filimosearch.data.model.ResponseSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServises {

    @GET("movie/movie/list/tagid/1000300/text/{Query}/sug/on")
    suspend fun searchMovie(@Path("Query") query: String) :Response<ResponseSearch>

}