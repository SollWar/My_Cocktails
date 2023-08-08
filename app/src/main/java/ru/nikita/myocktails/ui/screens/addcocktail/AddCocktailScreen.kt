package ru.nikita.myocktails.ui.screens.addcocktail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.nikita.myocktails.R
import ru.nikita.myocktails.ui.theme.Black
import ru.nikita.myocktails.ui.theme.ButtonColor
import ru.nikita.myocktails.ui.theme.ImageBackColor
import ru.nikita.myocktails.ui.theme.White
import ru.nikita.myocktails.ui.theme.font12sp
import ru.nikita.myocktails.ui.theme.font16sp
import ru.nikita.myocktails.ui.theme.font24sp
import ru.nikita.myocktails.ui.theme.font32sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "spec:width=360dp,height=996dp,dpi=440")
@Composable
fun AddCocktailScreen(
    onSaveButtonClick: () -> Unit = {},
    onCancelButtonClick: () -> Unit = {},
    viewModel: AddCocktailViewModel = hiltViewModel()
) {

    val cocktailNameState by viewModel.name.collectAsState()
    val cocktailDescriptionState by viewModel.description.collectAsState()
    val cocktailRecipeState by viewModel.recipe.collectAsState()
    val cocktailIngredientsState by viewModel.ingredients.collectAsState()
    var cocktailIngredientsSize by remember { mutableStateOf(cocktailIngredientsState.size) }

    var openDialog by remember { mutableStateOf(false) }
    var ingredientName by remember { mutableStateOf("Ingredient name") }

    if (openDialog) {
        AlertDialog(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            onDismissRequest = {
                openDialog = false
            },
            title = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Add ingredient",
                    style = font32sp(TextAlign.Center, Black)
                )
            },
            text = {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(34.dp),
                    value = ingredientName,
                    onValueChange = {
                        ingredientName = it
                    },
                    textStyle = font24sp(textAlign = TextAlign.Start, color = Black),
                    singleLine = true,
                    label = {
                        Text(
                            text = "Ingredient",
                            style = font12sp(TextAlign.Center)
                        )
                    },
                    supportingText = {
                        Text(
                            text = "Add title",
                            style = font12sp(TextAlign.Center)
                        )
                    }
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog = false
                        viewModel.addIngredient(ingredientName)
                        cocktailIngredientsSize = cocktailIngredientsState.size
                        ingredientName = "Ingredient name"
                    },
                    Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonColor
                    )
                ) {
                    Text(
                        text = "Save",
                        style = font24sp(color = White)
                    )
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        openDialog = false
                    },
                    Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        text = "Cancel",
                        style = font24sp(color = Black)
                    )
                }
            })
    }


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .padding(top = 64.dp, start = 72.dp, end = 72.dp)
                .clip(RoundedCornerShape(54.dp))
                .width(216.dp)
                .height(216.dp)
                .background(ImageBackColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Cocktails Image",
                tint = Black
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(34.dp),
            value = cocktailNameState,
            singleLine = true,
            onValueChange = {
                viewModel.changeName(it)
            },
            textStyle = font16sp(textAlign = TextAlign.Start, color = Black),
            label = {
                Text(
                    text = "Title",
                    style = font12sp(TextAlign.Center)
                )
            },
            supportingText = {
                Text(
                    text = "Add title",
                    style = font12sp(TextAlign.Center)
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(34.dp),
            value = cocktailDescriptionState,
            onValueChange = {
                viewModel.changeDescription(it)
            },
            textStyle = font16sp(textAlign = TextAlign.Start, color = Black),
            singleLine = false,
            label = {
                Text(
                    text = "Description",
                    style = font12sp(TextAlign.Center)
                )
            },
            supportingText = {
                Text(
                    text = "Optional field",
                    style = font12sp(TextAlign.Center)
                )
            }
        )

        Column(
            modifier = Modifier
                .padding(top = 22.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 2.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                Column {
                    repeat(cocktailIngredientsSize) {
                        Row(
                            modifier = Modifier
                                .padding(top = 2.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(24.dp)
                                    .wrapContentWidth()
                                    .border(
                                        width = 1.dp,
                                        color = Black,
                                        shape = RoundedCornerShape(34.dp)
                                    ),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(start = 10.dp, end = 4.dp)
                                            .fillMaxHeight(0.8f),
                                        text = cocktailIngredientsState[it],
                                        style = font12sp(TextAlign.Center)
                                    )
                                    Icon(
                                        Icons.Default.Clear,
                                        contentDescription = "Remove ingredients",
                                        modifier = Modifier
                                            .height(20.dp)
                                            .padding(end = 10.dp)
                                            .clickable {
                                                viewModel.removeIngredient(cocktailIngredientsState[it])
                                                cocktailIngredientsSize =
                                                    cocktailIngredientsState.size
                                            },
                                        tint = ButtonColor
                                    )
                                }
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(start = 2.dp, top = 4.dp)
                        .height(20.dp)
                        .clip(CircleShape)
                        .background(ButtonColor)
                        .clickable {
                            openDialog = true
                        },
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add ingredients",
                        tint = White
                    )
                }
            }
        }


        OutlinedTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(34.dp),
            value = cocktailRecipeState,
            onValueChange = {
                viewModel.changeRecipe(it)
            },
            textStyle = font16sp(textAlign = TextAlign.Start, color = Black),
            singleLine = false,
            label = {
                Text(
                    text = "Recipe",
                    style = font12sp(TextAlign.Center)
                )
            },
            supportingText = {
                Text(
                    text = "Optional field",
                    style = font12sp(TextAlign.Center)
                )
            }
        )
        Button(
            onClick = {
                viewModel.saveCocktail()
                onSaveButtonClick()
            },
            Modifier
                .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor
            )
        ) {
            Text(
                text = "Save",
                style = font24sp(color = White)
            )
        }
        OutlinedButton(
            onClick = {
                onCancelButtonClick()
            },
            Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Cancel",
                style = font24sp(color = Black)
            )
        }
    }
}