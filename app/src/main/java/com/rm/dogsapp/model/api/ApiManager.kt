package com.rm.dogsapp.model.api

import com.rm.dogsapp.model.response.DogBreedResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiManager {
    private lateinit var api: DogsApi
    init{
        //https://api.thedogapi.com/v1/breeds?limit=10&page=0
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(DogsApi::class.java)
    }
    suspend fun getBreeds(): List<DogBreedResponse> {
        return api.getBreeds()
    }

    interface DogsApi {
        @GET("breeds?limit=10&page=0")
        suspend fun getBreeds(): List<DogBreedResponse>
    }
}