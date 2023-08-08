package ru.nikita.myocktails.ui.screens.allcocktails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.nikita.myocktails.data.CocktailEntity
import ru.nikita.myocktails.ui.theme.White
import ru.nikita.myocktails.ui.theme.font18sp
import ru.nikita.myocktails.ui.theme.font36sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "id:pixel_7")
@Composable
fun AllCocktailsScreen(
    onItemClick: () -> Unit = {},
    onAddButtonClick: () -> Unit = {},
    viewModel: AllCocktailsViewModel = hiltViewModel()
) {

    viewModel.loadingCocktails()

    val cocktails by viewModel.cocktails.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAddButtonClick()
                }
            ) {

            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 24.dp),
                text = "My cocktails",
                style = font36sp()
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cocktails.size) {
                    CocktailItem(viewModel, onItemClick ,cocktails[it])
                }
            }
        }
    }
}

@Composable
fun CocktailItem(
    viewModel: AllCocktailsViewModel,
    onClick: () -> Unit = {},
    cocktailEntity: CocktailEntity
) {
    Box(
        Modifier
            .clip(RoundedCornerShape(54.dp))
            .width(160.dp)
            .height(160.dp)
            .clickable {
                onClick()
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(cocktailEntity.image),
            contentDescription = cocktailEntity.name,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 102.dp),
            text = cocktailEntity.name,
            style = font18sp(TextAlign.Center ,color = White)
        )
    }
}