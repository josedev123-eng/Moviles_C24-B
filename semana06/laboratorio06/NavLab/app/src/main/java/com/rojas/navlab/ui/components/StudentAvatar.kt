package com.rojas.navlab.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StudentAvatar(
    @DrawableRes res: Int,
    size: Dp,
    borderWidth: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = res),
        contentDescription = "Avatar de estudiante",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(size)
            .then(
                if (borderWidth > 0.dp) {
                    Modifier.border(borderWidth, Color.White, CircleShape)
                } else {
                    Modifier
                }
            )
            .clip(CircleShape)
    )
}
