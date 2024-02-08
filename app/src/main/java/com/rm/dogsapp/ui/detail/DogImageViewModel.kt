package com.rm.dogsapp.ui.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rm.dogsapp.model.DogRepository
import com.rm.dogsapp.model.response.DogImageDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DogImageViewModel (private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val imageJob = Job()

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val idImage = savedStateHandle.get<String>("dog_image_id") ?: ""
            val imageDetail = getDogImage(idImage)
            detailState.value = imageDetail
        }
    }

    val detailState: MutableState<DogImageDetail> =  mutableStateOf(DogImageDetail("", ""))
    override fun onCleared() {
        super.onCleared()
        imageJob.cancel()
    }

    suspend fun getDogImage(idImage: String): DogImageDetail {
        return DogRepository.getInstance().getDogImage(idImage)
    }
}