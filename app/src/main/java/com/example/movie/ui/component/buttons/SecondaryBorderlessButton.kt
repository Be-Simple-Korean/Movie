package com.example.movie.ui.component.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.unit.dp
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movie.ui.theme.Paddings
import com.example.movie.ui.theme.colorscheme

@Composable
fun SecondaryBorderlessButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(2.dp, MaterialTheme.colorscheme.secondary),
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorscheme.background,
            contentColor = MaterialTheme.colorscheme.secondary,
            disabledBackgroundColor = MaterialTheme.colorscheme.background,
            disabledContentColor = MaterialTheme.colorscheme.disabledSecondary
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.button.copy(
                ),
                modifier = Modifier.padding(Paddings.small)
            )
        }
    }
}
