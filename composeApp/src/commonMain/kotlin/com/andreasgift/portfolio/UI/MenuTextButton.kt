package com.andreasgift.portfolio.UI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andreasgift.portfolio.grayText
import com.andreasgift.portfolio.silverTextTitle

@Composable
fun MenuTextButton(callback:(Int) -> Unit) {
    val focusTextStyle = MaterialTheme.typography.subtitle1.copy(silverTextTitle)
    val unfocusTextStyle = MaterialTheme.typography.body1.copy(color = grayText)
    val textFocus = remember { mutableStateOf(0) }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text("- About",
            style = if(textFocus.value == 0 ) focusTextStyle else unfocusTextStyle,
            modifier = Modifier.clickable { textFocus.value = 0
            callback(0)}
                .hoverableExt { textFocus.value = 0
                callback(0)})
        Text(
            "- Experience",
            style = if(textFocus.value == 1 ) focusTextStyle else unfocusTextStyle,
            modifier = Modifier.clickable { textFocus.value = 1
            callback(1)}
                .hoverableExt { textFocus.value = 1
                callback(1)}
        )
        Text(
            "- Projects",
            style = if(textFocus.value == 2 ) focusTextStyle else unfocusTextStyle,
            modifier = Modifier.clickable { textFocus.value = 2
            callback(2)}
                .hoverableExt { textFocus.value = 2
                callback(2)}
        )
    }
}

@Composable
fun Modifier.hoverableExt(
    onClick: () -> Unit
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHoveredState = interactionSource.collectIsHoveredAsState()

    if (isHoveredState.value){onClick()}

    return Modifier.hoverable(
        interactionSource = interactionSource
    )
}