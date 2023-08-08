package ru.nikita.myocktails.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.nikita.myocktails.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val DidactGothic = FontFamily(
    Font(R.font.didactgothic_regular, FontWeight.Normal)
)

fun font36sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = PrimaryTextColor
): TextStyle = TextStyle(
    fontSize = 36.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign
)

fun font32sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = TextColor
): TextStyle = TextStyle(
    fontSize = 32.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign
)

fun font24sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = TextColor
): TextStyle = TextStyle(
    fontSize = 24.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign
)

fun font16sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = TextColor
): TextStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign
)

fun font12sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = TextColor
): TextStyle = TextStyle(
    fontSize = 12.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign
)

fun font18sp(
    textAlign: TextAlign = TextAlign.Center,
    color: Color = TextColor
): TextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = DidactGothic,
    fontWeight = FontWeight.Normal,
    color = color,
    textAlign = textAlign,
    shadow = Shadow(
        color = Black,
        offset = Offset(1f, 1f),
        blurRadius = 1f
    )
)