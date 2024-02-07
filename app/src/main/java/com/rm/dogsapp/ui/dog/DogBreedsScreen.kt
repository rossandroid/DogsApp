package com.rm.dogsapp.ui.dog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
     ElevatedCard(shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
         Column(modifier = Modifier
             .align(Alignment.CenterHorizontally)
             .padding(16.dp)) {
             Text(text =  breed.name,
                 style = MaterialTheme.typography.bodyMedium)
         }

     }

    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsAppTheme {
        DogBreedsScreen()
    }
}
