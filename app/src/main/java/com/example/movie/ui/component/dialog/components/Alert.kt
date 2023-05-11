package com.example.movie.ui.component.dialog.components

import android.app.Dialog
import androidx.compose.runtime.Composable
import com.example.movie.ui.component.dialog.BaseDialog
import com.example.movie.ui.component.dialog.DialogPopup
import com.example.movie.ui.models.dialog.DialogButton
import com.example.movie.ui.models.dialog.DialogContent
import com.example.movie.ui.models.dialog.DialogText
import com.example.movie.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialog(
        dialogTitle = DialogTitle.Header(
            title
        ),
        dialogContent = DialogContent.Large(
            DialogText.Default(
                bodyText
            )
        ),
        buttons = buttons
    )
}