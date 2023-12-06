package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column {
        SectionText(title = title, modifier)
        content()
    }
}

@Composable
fun ArticleSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column {
        SectionText(title = title, modifier)
        content()
    }
}

@Composable
fun CategorySection(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column {
        SectionText4(text1 = text1, text2 = text2, modifier)
        content()
    }
}