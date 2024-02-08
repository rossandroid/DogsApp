package com.rm.dogsapp.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

import com.rm.dogsapp.ui.theme.DogsAppTheme


@Composable
fun DogDetailsScreen() {
    val viewModel: DogImageViewModel = viewModel()
    val imageUrl = viewModel.detailState.value.imageUrl
    LazyColumn {
        item {
            DogImage(imageUrl)
        }
    }

}
@Composable
fun DogImage(imageUrl: String){
    Row{
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.CenterVertically)){
            AsyncImage(
                modifier = Modifier.size(200.dp)
                    .align(Alignment.CenterHorizontally),
                model = imageUrl,
                contentDescription = "Dog Image"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsAppTheme {
        DogDetailsScreen()
    }
}