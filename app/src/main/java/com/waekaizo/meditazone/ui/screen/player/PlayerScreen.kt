package com.waekaizo.meditazone.ui.screen.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.components.TopBarCategory
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun PlayerScreen() {
    PlayerContent(
        title = "Serenity Streams",
        category = "Mindfullness"
    )
}

@Composable
fun PlayerContent(
    title: String,
    category: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.player_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBarCategory(modifier = Modifier.padding(top = 16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(vertical = 24.dp)
            )
            Text(
                text = category,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 24.dp)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 40.dp)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_tenleft),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .size(50.dp)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_tenright),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerScreenPreview() {
    MeditazoneTheme {
        PlayerScreen()
    }
}
