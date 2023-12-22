package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey_TIL
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.Purple_Button2

@Composable
fun EmotionDetect(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(323.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Grey_TIL
        )
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.emot_smile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .size(20.dp)
            )
            Text(
                text = stringResource(id = R.string.text_ask_emotion),
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Composable
fun EmotionDetectML(
    classPredict: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    clearClassPredict: () -> Unit
) {
    Card(
        modifier = modifier
            .width(323.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Grey_TIL
        )
    ) {
        Row(
            modifier = Modifier
                .height(55.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.your_feel),
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            ShowClassPredict(
                classPredict = classPredict,
                icon = icon,
                clearClassPredict = clearClassPredict
            )
        }
    }
}

@Composable
fun ShowClassPredict(
    classPredict: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    clearClassPredict: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .size(height = 40.dp, width = 110.dp)
            .background(color = Purple_Button2, shape = RoundedCornerShape(20.dp))
            .padding(vertical = 2.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .size(15.dp)
        )
        Text(
            text = classPredict,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
        )
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(5.dp)
                .background(color = Color.Black.copy(alpha = 0.6F), shape = CircleShape)
                .size(15.dp)
                .padding(4.dp)
                .clickable {
                    clearClassPredict()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmotionDetectPreview() {
    MeditazoneTheme {
        EmotionDetect()
    }
}

@Preview(showBackground = true)
@Composable
fun EmotionDetectMLPreview() {
    MeditazoneTheme {
        EmotionDetectML(
            classPredict = "Anxiety",
            icon = painterResource(id = R.drawable.emot_smile),
            clearClassPredict = {}
        )
    }
}