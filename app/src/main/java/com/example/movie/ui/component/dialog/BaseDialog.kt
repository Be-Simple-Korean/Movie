package com.example.movie.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movie.ui.models.dialog.DialogButton
import com.example.movie.ui.models.dialog.DialogContent
import com.example.movie.ui.models.dialog.DialogTitle
import com.example.movie.ui.component.dialog.components.buttons.DialogButtonsCustom
import com.example.movie.ui.component.dialog.components.content.DialogContentWrapper
import com.example.movie.ui.component.dialog.components.title.DialogTitleWrapper
import com.example.movie.ui.models.dialog.DialogText
import com.example.movie.ui.theme.MovieTheme
import com.example.movie.ui.theme.Paddings
import com.example.movie.ui.theme.colorscheme

@Composable
fun BaseDialog(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = Paddings.none,
        backgroundColor = MaterialTheme.colorscheme.background,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(start = Paddings.large, end = Paddings.xlarge, bottom = Paddings.xlarge)
            ) {
                dialogContent?.let {
                    DialogContentWrapper(it)
                }
                buttons?.let {
                    DialogButtonsCustom(it)
                }
            }
        }
    }
}


@Preview
@Composable
fun BPP() {
    MovieTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Large(DialogText.Default("abcd abcd abcd abcd abcd abcd abcd")),
            buttons = listOf(DialogButton.Primary("Okay") {})
        )

    }
}



@Preview
@Composable
fun BaseDialogPopupPreview2() {
    MovieTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Large("TITLE"),
            dialogContent = DialogContent.Default(
                DialogText.Default("abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde")
            ),
            buttons = listOf(
                DialogButton.Secondary("Okay") {},
                DialogButton.UnderlinedText("Cancel") {}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview3() {
    MovieTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Large("TITLE"),
            dialogContent = DialogContent.Rating(
                DialogText.Rating(
                    text = "Jurassic Park",
                    rating = 3.0f
                )
            ),
            buttons = listOf(
                DialogButton.Primary("Okay") {},
                DialogButton.Secondary("Cancel") {}
            )
        )
    }
}