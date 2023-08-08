package ru.nikita.myocktails.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nikita.myocktails.R
import ru.nikita.myocktails.ui.theme.ButtonColor
import ru.nikita.myocktails.ui.theme.White
import ru.nikita.myocktails.ui.theme.font16sp
import ru.nikita.myocktails.ui.theme.font36sp

@Preview(device = "spec:width=360dp,height=640dp,dpi=440")
@Composable
fun EmptyScreen(onClick: () -> Unit = {}) {
    Column(
        Modifier
            .padding(top = 33.dp)
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .width(283.dp)
                .height(283.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.hello),
                contentDescription = "Hello",
                contentScale = ContentScale.FillBounds
            )
        }

        Box(
            Modifier

        ) {
            Text(
                text = "My cocktails",
                style = font36sp()
            )
        }
        Box(
            Modifier
                .padding(top = 32.dp)
                .width(130.dp)
                .height(185.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add your first cocktail here",
                    style = font16sp(TextAlign.Center)
                )
                Icon(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                    painter = painterResource(id = R.drawable.arrow_1),
                    contentDescription = "Arrow down"
                )
                Box(
                    Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(CircleShape)
                        .background(ButtonColor)
                        .clickable {
                                   onClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        tint = White
                    )
                }
            }
        }
    }
}