package com.rm.dogsapp.model

import com.rm.dogsapp.model.api.ApiManager
import com.rm.dogsapp.model.response.DogBreedResponse
import com.rm.dogsapp.model.response.DogImageDetail

class DogRepository (private val webService: ApiManager = ApiManager()) {
    suspend fun getDogBreeds(): List<DogBreedResponse> {
        return webService.getBreeds()
    }

    suspend fun getDogImage(idBreed: String): DogImageDetail{
        return webService.getDogImage(idBreed)
    }

    companion object {
        @Volatile
        private var instance: DogRepository? = null
        fun getInstance() = instance ?: synchronized(this){
            instance ?: DogRepository().also { instance = it }
        }
    }
}