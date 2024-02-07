package com.rm.dogsapp.model

import com.rm.dogsapp.model.api.ApiManager
import com.rm.dogsapp.model.response.DogBreedResponse

class DogRepository (private val webService: ApiManager = ApiManager()) {
    suspend fun getDogBreeds(): List<DogBreedResponse> {
        return webService.getBreeds()
    }
}