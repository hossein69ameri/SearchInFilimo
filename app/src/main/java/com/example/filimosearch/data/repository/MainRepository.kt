package com.example.filimosearch.data.repository

import com.example.filimosearch.data.api.ApiServises
import com.example.filimosearch.data.model.ResponseSearch
import com.example.filimosearch.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServises: ApiServises) {

    suspend fun searchMovie(query: String): Flow<NetworkResult<ResponseSearch>> {
        return flow {
            emit(NetworkResult.loading())
            when (apiServises.searchMovie(query).code()) {
                200 -> {
                    emit(NetworkResult.success(apiServises.searchMovie(query).body()))
                }
            }
        }.catch {
            emit(NetworkResult.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
    }
}