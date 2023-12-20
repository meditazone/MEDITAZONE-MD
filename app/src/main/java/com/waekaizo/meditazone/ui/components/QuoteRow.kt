package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.model.FakeQuoteData
import com.waekaizo.meditazone.model.Quote
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun QuoteRow(
    listQuote: List<QuoteItem>,
    modifier: Modifier = Modifier,
    onQuoteClick: () -> Unit,
    showDialog: Boolean,
    onDismissDialog: () -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listQuote, key = { it.quoteID }) {quote ->
            QuoteItem(
                quote = quote.quote,
                nameMotivator = quote.author,
                backgroundUrl = quote.imageUrl,
                modifier = Modifier
                    .clickable { onQuoteClick() },
                showDialog = showDialog,
                onDismissDialog = onDismissDialog
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteRowPreview() {
    MeditazoneTheme {
        QuoteRow(
            listQuote = FakeQuoteData.quotes,
            onQuoteClick = {},
            showDialog = false,
            onDismissDialog = {}
        )
    }
}