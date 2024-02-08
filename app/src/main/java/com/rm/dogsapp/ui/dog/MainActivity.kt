package com.rm.dogsapp.ui.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rm.dogsapp.ui.detail.DogDetailsScreen
import com.rm.dogsapp.ui.detail.DogImageViewModel
import com.rm.dogsapp.ui.theme.DogsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsAppTheme {
                DogBreedsApp()
            }
        }
    }
    @Composable
    private fun DogBreedsApp(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "destination_dog_breeds"){
            composable(route = "destination_dog_breeds"){
                DogBreedsScreen(){ navigationBreedId ->
                    navController.navigate("destination_dog_detail/$navigationBreedId")
                }
            }
            composable(
                route = "destination_dog_detail/{dog_image_id}",
                arguments = listOf(navArgument("dog_image_id"){
                    type = NavType.StringType
                })
            ){
                DogDetailsScreen()
            }
        }


    }
}