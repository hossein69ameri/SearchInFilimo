package com.example.filimosearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filimosearch.data.model.ResponseSearch
import com.example.filimosearch.data.repository.MainRepository
import com.example.filimosearch.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _stateResponse : MutableStateFlow<NetworkResult<ResponseSearch>?> = MutableStateFlow(null)
    val stateResponse = _stateResponse.asStateFlow()


    fun searchMovie(query : String) = viewModelScope.launch {
        mainRepository.searchMovie(query).collect{
            _stateResponse.value = it
        }
    }

}