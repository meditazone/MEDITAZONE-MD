package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey40
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.robotoFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteBottomSheet(
    showBottomSheet: Boolean,
    sheetState: SheetState,
    title: String,
    subTitle: String
) {
    Button(onClick = {  }) {
        Text(text = "Open Sheet")
    }
    ModalBottomSheet(
        onDismissRequest = {
        },
    ) {
        // Sheet content
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.meditation_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                )
                Column(
                    modifier = Modifier
                        .padding(bottom = 8.dp, start = 8.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = robotoFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = subTitle,
                        fontSize = 12.sp,
                        color = Grey40,
                        modifier = Modifier
                            .padding(top = 8.dp),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clickable { }
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.favorite),
                    fontFamily = robotoFontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .clickable { }
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.share),
                    fontFamily = robotoFontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FavoriteBottomSheetPreview() {
    MeditazoneTheme {
        FavoriteBottomSheet(
            showBottomSheet = true,
            sheetState = rememberModalBottomSheetState(),
            title = "Bearth Aweness",
            subTitle = "Meditasi Pernapasan"
        )
    }
}