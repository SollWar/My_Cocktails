package ru.nikita.myocktails

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.nikita.myocktails.ui.screens.addcocktail.AddCocktailScreen
import ru.nikita.myocktails.ui.screens.allcocktails.AllCocktailsScreen
import ru.nikita.myocktails.ui.screens.DetailedCocktailScreen
import ru.nikita.myocktails.ui.screens.EmptyScreen
import ru.nikita.myocktails.ui.theme.MyСocktailsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainViewModel>()

        setContent {
            MyСocktailsTheme {
                val navHostController = rememberNavController()

                viewModel.getAllCocktail()

                val cocktailListState by viewModel.cocktailsList.collectAsState()


                Log.d("getAllCocktail", cocktailListState.toString())



                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navHostController, startDestination =  if (cocktailListState.isEmpty()) "EmptyScreen" else "AllCocktailsScreen") {
                        composable("EmptyScreen") {
                            EmptyScreen { navHostController.navigate("AddCocktailsScreen") }
                        }
                        composable("AllCocktailsScreen") {
                            AllCocktailsScreen(
                                onItemClick = {navHostController.navigate("DetailedCocktailScreen")},
                                onAddButtonClick = {navHostController.navigate("AddCocktailsScreen")}
                            )
                        }
                        composable("AddCocktailsScreen") {
                            AddCocktailScreen(
                                onSaveButtonClick = {navHostController.popBackStack()},
                                onCancelButtonClick = {navHostController.popBackStack()}
                            )
                        }
                        composable("DetailedCocktailScreen"
                        ) {
                            DetailedCocktailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyСocktailsTheme {
        Greeting("Android")
    }
}