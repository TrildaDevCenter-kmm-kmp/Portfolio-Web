package com.andreasgift.portfolio.UI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolioweb.composeapp.generated.resources.Res
import portfolioweb.composeapp.generated.resources.github_icon
import portfolioweb.composeapp.generated.resources.linkedin_icon
import portfolioweb.composeapp.generated.resources.medium_icon

@Composable
fun IconButtons() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically) {
        IconButton(Res.drawable.github_icon, "https://github.com/andrea-liu87")
        IconButton(Res.drawable.linkedin_icon, "https://www.linkedin.com/in/andrealiu87/")
        IconButton(Res.drawable.medium_icon, "https://medium.com/@andrea8787")
    }
}

@Composable
private fun IconButton(image: DrawableResource, url: String){
    val uriHandler = LocalUriHandler.current
    Icon(
        modifier = Modifier
            .size(24.dp)
            .clickable { uriHandler.openUri(url) }
            .background(Color.White)
            .clip(RoundedCornerShape(12.dp)),
        painter = painterResource(image),
        contentDescription = null,
        tint = Color.Unspecified
    )
}