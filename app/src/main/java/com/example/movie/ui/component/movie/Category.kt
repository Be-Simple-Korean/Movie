package com.example.movie.ui.component.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie.ui.theme.MovieTheme
import com.example.movie.ui.theme.Paddings
import java.util.Locale.Category

@Composable
fun CategoryRow() {
    Column {
        CategoryTitle("Action")
        LazyRow(contentPadding = PaddingValues(horizontal = Paddings.large)) {
            item {
                MovieItem()
            }
        }
    }
}

@Composable
fun CategoryTitle(title: String) {
    Text(text = title, modifier = Modifier.padding(vertical = Paddings.large, horizontal = Paddings.extra), style = MaterialTheme.typography.h5)
}

@Preview
@Composable
fun CategoryPreView() {
    MovieTheme {
        CategoryRow()
    }
}



