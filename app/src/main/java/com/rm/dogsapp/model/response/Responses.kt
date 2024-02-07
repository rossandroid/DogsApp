package com.rm.dogsapp.model.response

import com.google.gson.annotations.SerializedName

data class DogBreedResponse(
    @SerializedName("id")  val  id: Int,
    @SerializedName("name")  val  name: String,
    @SerializedName("reference_image_id")  val  imageUrl: String,
    @SerializedName("origin")  val  origin: String
)
