package com.waekaizo.meditazone.ui.screen.success

import androidx.compose.runtime.Composable
import com.waekaizo.meditazone.ui.components.SuccessDialog

@Composable
fun ShowSuccessDialog(
    navigateBack: () -> Unit,
) {
    SuccessDialog(onDismiss = { navigateBack() })
}