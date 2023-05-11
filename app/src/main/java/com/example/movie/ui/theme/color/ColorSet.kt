package com.example.movie.ui.theme.color

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color.Companion.White

sealed class ColorSet {
    open lateinit var LightColors: MyColors
    open lateinit var DarkColors: MyColors

    object Red : ColorSet() {
        override var LightColors = MyColors(
            material = lightColors(
                primary = Red700,
                primaryVariant = Red800,
                secondary = Purple900,
                secondaryVariant = Purple700,
                surface = White,
                onSurface = Black,
                background = White,
                onBackground = Black,
                error = Red400,
                onPrimary = White
            ),
            success = Green400,
            disabledSecondary = Grey200,
            textFiledBackground = Grey200
        )

        @SuppressLint("ConflictingOnColor")
        override var DarkColors = MyColors(
            material = darkColors(
                primary = Purple900,
                primaryVariant = Red800,
                secondary = Purple900,
                secondaryVariant = Purple700,
                surface = White,
                onSurface = Black,
                background = White,
                onBackground = Black,
                error = Red400,
                onPrimary = White
            )
        )
    }

    object Blue : ColorSet() {
        override var LightColors = MyColors(
            material = lightColors(
                primary = Blue400,
                primaryVariant = Purple400,
                secondary = Red900,
                secondaryVariant = Red700,
                surface = White,
                onSurface = Purple900,
                background = White,
                onBackground = Purple900,
                error = Red400,
                onPrimary = White
            ),
            success = Green400,
            disabledSecondary = Purple700,
            textFiledBackground = Grey200
        )

        override var DarkColors = MyColors(
            material = darkColors(
                primary = Red900,
                primaryVariant = Purple400,
                secondary = Blue400,
                secondaryVariant = Purple900,
                surface = White,
                onSurface = Purple900,
                background = White,
                onBackground = Purple900,
                error = Red400,
                onPrimary = White
            )
        )
    }
}