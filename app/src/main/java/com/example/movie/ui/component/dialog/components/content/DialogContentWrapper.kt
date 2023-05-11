package com.example.movie.ui.component.dialog.components.content

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.em
import com.example.movie.ui.models.dialog.DialogContent
import com.example.movie.ui.models.dialog.DialogText
import com.example.movie.ui.theme.Paddings

data class DialogContentStyle(
    val textStyle: @Composable () -> TextStyle = { MaterialTheme.typography.body1 },
    val contentTopPadding: Dp = Paddings.xlarge,
    val contentBottomPaidding: Dp = Paddings.extra,
)

val LocalDialogContentStyle = compositionLocalOf { DialogContentStyle() }

@Composable
fun ColumnScope.DialogContentWrapper(content: DialogContent) {
    when (content) {
        is DialogContent.Default -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = { MaterialTheme.typography.body2.copy(lineHeight = 1.6.em) },
                    contentTopPadding = Paddings.small,
                    contentBottomPaidding = Paddings.extra
                )
            ) {
                NormalTextContent(content.dialogText)
            }
        }
        is DialogContent.Large -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = { MaterialTheme.typography.body2.copy(lineHeight = 1.6.em) },
                    contentTopPadding = Paddings.extra,
                    contentBottomPaidding = Paddings.extra
                )
            ) {
                NormalTextContent(content.dialogText)
            }
        }
        is DialogContent.Rating -> {
            RatingContent(content.dialogText)
        }
    }
}



@Composable
fun ColumnScope.NormalTextContent(dialogText: DialogText.Default) {
    Text(
        text = getStringFromDialogText(dialogText),
        modifier = Modifier
            .padding(
                top = LocalDialogContentStyle.current.contentTopPadding,
                bottom = LocalDialogContentStyle.current.contentBottomPaidding
            )
            .align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        style = LocalDialogContentStyle.current.textStyle.invoke()
    )

}

@Composable
fun getStringFromDialogText(text: DialogText.Default): String {
    return if (text.id != null) {
        stringResource(id = text.id!!)
    } else {
        text.text ?: ""
    }

}