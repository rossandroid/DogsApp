package com.rm.dogsapp.ui.dog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rm.dogsapp.model.response.DogBreedResponse
import com.rm.dogsapp.ui.theme.DogsAppTheme

@Composable
fun DogBreedsScreen(navigationCallback: (String) -> Unit) {
    val viewModel: DogViewModel = viewModel()
    val breeds = viewModel.breedsState.value

    LazyColumn {
        items(breeds) {breed->
            DogBreed(breed, navigationCallback)
        }
    }
}

@Composable
fun DogBreed(breed: DogBreedResponse, navigationCallback: (String) -> Unit){
    var isExpanded by remember { mutableStateOf(false) }

     ElevatedCard(shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    navigationCallback(breed.imageUrl)
                }) {
         Column(modifier = Modifier
             .align(Alignment.Start)
             .padding(16.dp)) {
             Text(text =  breed.name,
                 style = MaterialTheme.typography.bodyLarge)

             if(!breed.origin.isNullOrEmpty()){
                 CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {

                         Text(text = ("Origin: \n" + breed.origin),
                             style = MaterialTheme.typography.bodyMedium,
                             overflow = TextOverflow.Ellipsis,
                             maxLines = if(isExpanded) 2 else 1)
                 }
             }
         }
         if(!breed.origin.isNullOrEmpty()){
             Icon(
                 imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                 contentDescription = "Expand row icon",
                 modifier = Modifier
                     .padding(2.dp)
                     .align(Alignment.CenterHorizontally)
                     .clickable { isExpanded = !isExpanded }
             )
         }
     }

    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsAppTheme {
        DogBreedsScreen({})
    }
}
