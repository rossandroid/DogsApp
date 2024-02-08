package com.rm.dogsapp.ui.dog

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rm.dogsapp.model.DogRepository
import com.rm.dogsapp.model.response.DogBreedResponse
import com.rm.dogsapp.model.response.DogImageDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DogViewModel (): ViewModel() {
    private val breedsJob = Job()
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val breeds = getBreedsList()
            breedsState.value = breeds
        }
    }

    val breedsState: MutableState<List<DogBreedResponse>> =  mutableStateOf(emptyList<DogBreedResponse>())
    override fun onCleared() {
        super.onCleared()
        breedsJob.cancel()
    }

    suspend fun getBreedsList(): List<DogBreedResponse> {
        return DogRepository.getInstance().getDogBreeds()
    }

}