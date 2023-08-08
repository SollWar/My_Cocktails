package ru.nikita.myocktails.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import ru.nikita.myocktails.R
import ru.nikita.myocktails.data.CocktailEntity
import ru.nikita.myocktails.ui.theme.Black
import ru.nikita.myocktails.ui.theme.ButtonColor
import ru.nikita.myocktails.ui.theme.White
import ru.nikita.myocktails.ui.theme.font16sp
import ru.nikita.myocktails.ui.theme.font24sp
import ru.nikita.myocktails.ui.theme.font32sp

@Composable
fun DetailedCocktailScreen() {

    val cocktailEntity = CocktailEntity()

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(329.dp),
            painter = painterResource(cocktailEntity.image),
            contentDescription = cocktailEntity.name,
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(top = 268.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 54.dp,
                        topEnd = 54.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(White)
        ) {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    text = cocktailEntity.name,
                    style = font32sp(color = Black)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    text = cocktailEntity.description,
                    style = font16sp(color = Black)
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                repeat(cocktailEntity.ingredients.size) {
                    if (it > 0) {
                        Image(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .height(1.dp),
                            painter = painterResource(R.drawable.line_1),
                            contentDescription = "Separator",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = cocktailEntity.ingredients[it],
                        style = font16sp(color = Black)
                    )
                }
            }
            Box(
                Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(80.dp))
                    .background(ButtonColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth(),
                    text = "Edit",
                    style = font24sp(color = White)
                )
            }
        }
    }
}