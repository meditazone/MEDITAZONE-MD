package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.model.FakeQuoteData
import com.waekaizo.meditazone.model.Quote
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun QuoteRow(
    listQuote: List<Quote>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listQuote, key = { it.id}) {quote ->
            QuoteItem(
                quote = quote.quote,
                nameMotivator = quote.namePeople,
                backgroundUrl = quote.backgroundUrl
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteRowPreview() {
    MeditazoneTheme {
        QuoteRow(
            listQuote = FakeQuoteData.quotes
        )
    }
}