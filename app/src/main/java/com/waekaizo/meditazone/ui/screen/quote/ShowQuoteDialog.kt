package com.waekaizo.meditazone.ui.screen.quote

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.QuoteDialog
import com.waekaizo.meditazone.ui.screen.home.HomeViewModel

@Composable
fun ShowQuoteDialog(
    quoteId: Int,
    navigateBack: () -> Unit,
    viewModel: QuoteViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { quoteList ->
        when(quoteList) {
            is UiState.Loading -> {
                viewModel.getQuoteById(quoteId)
            }
            is UiState.Success -> {
                val data = quoteList.data

                QuoteDialog(
                    quote = data.quote,
                    nameMotivator = data.author,
                    backgroundUrl = data.imageUrl,
                    onDismiss = navigateBack
                )
            }
            is UiState.Error -> {

            }
        }
    }
}