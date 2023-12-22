package com.waekaizo.meditazone.ui.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.components.SearchBar
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun SearchScreen() {
    SearchContent()
}

@Composable
fun SearchContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_search),
            contentDescription = stringResource(id = R.string.background_search),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(

        ) {
            item {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.button_close),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color.Black, shape = CircleShape)
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
                SearchBar(
                    query = "",
                    onQueryChange = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MeditazoneTheme {
        SearchScreen()
    }
}
