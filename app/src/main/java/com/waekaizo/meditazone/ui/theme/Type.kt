package com.waekaizo.meditazone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.waekaizo.meditazone.R

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

val prozaLibreFontFamily = FontFamily(
    Font(R.font.prozalibre_bold, FontWeight.Bold),
    Font(R.font.prozalibre_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.prozalibre_extrabold, FontWeight.ExtraBold),
    Font(R.font.prozalibre_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.prozalibre_medium, FontWeight.Medium),
    Font(R.font.prozalibre_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.prozalibre_regular, FontWeight.Normal),
    Font(R.font.prozalibre_semibold, FontWeight.SemiBold),
    Font(R.font.prozalibre_semibolditalic, FontWeight.SemiBold, FontStyle.Italic)
)

val robotoFontFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thinitalic, FontWeight.Thin, FontStyle.Italic)
)