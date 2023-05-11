package com.example.movie.ui.component.buttons

import android.widget.Space
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie.ui.models.buttons.LeadingIconData
import com.example.movie.ui.theme.Paddings
import com.example.movie.ui.theme.colorscheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    leadingIconData: LeadingIconData? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorscheme.primary,
            contentColor = MaterialTheme.colorscheme.onPrimary,
            disabledBackgroundColor = MaterialTheme.colorscheme.background,
            disabledContentColor = MaterialTheme.colorscheme.onBackground
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIconData?.let {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = leadingIconData.iconDrawable),
                    contentDescription = leadingIconData.iconContentDesc?.let { desc -> stringResource(id = desc) }
                )
                Spacer(modifier = Modifier.width(Paddings.small))
            }
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(Paddings.small)
            )
        }
    }
}

@Preview
@Composable
fun PBPreview() {
    MaterialTheme {
        PrimaryButton(text = "SUBMIT") {

        }
    }
}