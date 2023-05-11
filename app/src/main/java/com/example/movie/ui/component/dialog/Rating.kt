package com.example.movie.ui.component.dialog

import android.app.Dialog
import androidx.compose.runtime.Composable
import com.example.movie.ui.models.dialog.DialogButton
import com.example.movie.ui.models.dialog.DialogContent
import com.example.movie.ui.models.dialog.DialogText
import com.example.movie.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialog(
        dialogTitle = DialogTitle.Large("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}