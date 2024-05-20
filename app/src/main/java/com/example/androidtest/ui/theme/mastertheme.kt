package com.example.androidtest.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun mastertheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}
