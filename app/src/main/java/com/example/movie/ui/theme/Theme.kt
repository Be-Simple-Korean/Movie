package com.example.movie.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.movie.ui.theme.color.ColorSet
import com.example.movie.ui.theme.color.MyColors

private val LocalColors = staticCompositionLocalOf { ColorSet.Red.LightColors }

@Composable
fun MovieTheme(colors: ColorSet=ColorSet.Red, darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        colors.DarkColors
    } else {
        colors.LightColors
    }

    CompositionLocalProvider(LocalColors provides  colors) {
        MaterialTheme(
            colors = colors.material,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

val MaterialTheme.colorscheme: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
