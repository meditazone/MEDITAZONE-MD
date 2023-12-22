package com.waekaizo.meditazone.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey_Card2
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.prozaLibreFontFamily
import com.waekaizo.meditazone.ui.theme.robotoFontFamily
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QuoteDialog(
    quote: String,
    nameMotivator: String,
    backgroundUrl: String,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Dialog(
            onDismissRequest = {
                onDismiss()
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(alpha = 0.8F))
                    .padding(end = 24.dp)
            ) {
                IconButton(
                    onClick = { onDismiss() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .background(color = Color.Black, shape = CircleShape)
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                ) {
                    Card(
                        modifier = modifier
                            .size(width = 353.dp, height = 486.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(60.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.background_quote),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .matchParentSize()
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(alignment = Alignment.Center)
                                    .padding(bottom = 32.dp, start = 24.dp, end = 24.dp)
                            ) {
                                Text(
                                    text = quote,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(vertical = 8.dp),
                                    textAlign = TextAlign.Start
                                )
                                Row {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_line),
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(60.dp)
                                            .align(Alignment.CenterVertically)
                                    )
                                    Text(
                                        text = nameMotivator,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 20.sp,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(
                                                top = 8.dp,
                                                bottom = 8.dp,
                                                end = 8.dp,
                                                start = 4.dp
                                            )
                                            .align(Alignment.CenterVertically),
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                                }
                            },
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .offset(y = 10.dp)
                                .size(70.dp)
                                .shadow(elevation = 10.dp, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                                    .padding(20.dp)
                            )
                        }
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                                }
                            },
                            modifier = Modifier
                                .padding(end = 32.dp)
                                .offset(y = 10.dp)
                                .size(70.dp)
                                .shadow(elevation = 10.dp, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                                    .padding(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(523.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.error_image),
                    contentDescription = stringResource(id = R.string.desc_image_error),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(183.dp)
                        .padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.error_message),
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    fontFamily = prozaLibreFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.error_message_desc),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = robotoFontFamily,
                    fontSize = 12.sp
                )
                ButtonGradient(
                    textButton = "Cerita Kembali",
                    onClick = { onDismiss() }
                )
            }
        }
    }
}

@Composable
fun TextFieldDialog(
    onValueChange: (String) -> Unit,
    onDismiss: () -> Unit,
    value: String,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.input_name),
                    fontFamily = prozaLibreFontFamily,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                )
                TextField(
                    value = value,
                    onValueChange = {
                        onValueChange
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = stringResource(id = R.string.name)
                        )
                    },
                )
            }
        }
    }
}

@Composable
fun SuccessDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.8F))
                .padding(end = 24.dp, start = 24.dp)
        ) {
            IconButton(
                onClick = {onDismiss()},
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color.Black, shape = CircleShape)
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
            ) {
                Card(
                    modifier = modifier
                        .size(width = 353.dp, height = 486.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(60.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.background_quote),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .matchParentSize()
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon_quote),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(horizontal = 24.dp, vertical = 40.dp)
                                .align(Alignment.TopStart)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(alignment = Alignment.Center)
                                .padding(bottom = 32.dp, start = 24.dp, end = 24.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.response_success),
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(vertical = 8.dp),
                                textAlign = TextAlign.Start
                            )
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_line),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .align(Alignment.CenterVertically)
                                )
                                Text(
                                    text = stringResource(id = R.string.meditazone_team),
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(
                                            top = 8.dp,
                                            bottom = 8.dp,
                                            end = 8.dp,
                                            start = 4.dp
                                        )
                                        .align(Alignment.CenterVertically),
                                    textAlign = TextAlign.Start
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleDialog(
    articleId: Int,
    title: String,
    thumbnail: String,
    author: String,
    category: String,
    articleUrl: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.8F))
                .padding(end = 24.dp, start = 24.dp)
        ) {
            IconButton(
                onClick = { onDismiss() },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color.Black, shape = CircleShape)
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
            ) {
                Card(
                    modifier = modifier
                        .size(width = 353.dp, height = 486.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        //Need to change to AsyncImage if already create
                        AsyncImage(
                            model = thumbnail,
                            contentDescription = stringResource(id = R.string.meditation_image),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .matchParentSize(),
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(alignment = Alignment.BottomStart)
                                .background(color = Grey_Card2)
                        ) {
                            Text(
                                text = title,
                                modifier = Modifier.padding(16.dp),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = author,
                                maxLines = 1,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(16.dp),
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun QuoteDialogPreview() {
    MeditazoneTheme {
        QuoteDialog(
            quote = "Kamu tidak dapat mengontrol semuanya. Terkadang kamu hanya perlu rileks dan yakin bahwa segala sesuatunya akan berhasil. Lepaskan sedikit dan biarkan hidup berjalan selayaknya air mengalir",
            nameMotivator = "Jon Hamm",
            backgroundUrl = "",
            onDismiss = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDialogPreview() {
    MeditazoneTheme {
        ErrorDialog(
            onDismiss = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldDialogPreview() {
    MeditazoneTheme {
        TextFieldDialog(
            onDismiss = {},
            value = "",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessDialogPreview() {
    MeditazoneTheme {
        SuccessDialog(
            onDismiss = { /*TODO*/ }
        )
    }
}*/

@Preview(showBackground = true)
@Composable
fun ArticleDialogPreview() {
    MeditazoneTheme {
        ArticleDialog(
            articleId = 1,
            title = "",
            thumbnail = "",
            author = "",
            category = "",
            articleUrl = "",
            onDismiss = {}
        )
    }
}