package com.rm.dogsapp.ui.dog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rm.dogsapp.model.response.DogBreedResponse
import com.rm.dogsapp.ui.theme.DogsAppTheme

@Composable
fun DogBreedsScreen() {
    val viewModel: DogViewModel = viewModel()
    val breeds = viewModel.breedsState.value

    LazyColumn {
        items(breeds) {breed->
            DogBreed(breed)
        }
    }
}

@Composable
fun DogBreed(breed: DogBreedResponse){
    Row{
//        AsyncImage(
//            model = "https://example.com/image.jpg",
//            contentDescription = null,
//        )
        Text(text = breed.name)
    }
    //
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsAppTheme {
        DogBreedsScreen()
    }
}
