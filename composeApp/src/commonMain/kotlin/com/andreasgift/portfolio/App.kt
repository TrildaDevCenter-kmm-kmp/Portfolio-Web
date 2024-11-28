package com.andreasgift.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.andreasgift.portfolio.UI.DescriptionText
import com.andreasgift.portfolio.UI.IconButtons
import com.andreasgift.portfolio.UI.MenuTextButton
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import portfolioweb.composeapp.generated.resources.Res
import portfolioweb.composeapp.generated.resources.about_us
import portfolioweb.composeapp.generated.resources.allDrawableResources
import portfolioweb.composeapp.generated.resources.compose_multiplatform
import portfolioweb.composeapp.generated.resources.experience
import portfolioweb.composeapp.generated.resources.github_icon
import portfolioweb.composeapp.generated.resources.linkedin_icon
import portfolioweb.composeapp.generated.resources.medium_icon
import portfolioweb.composeapp.generated.resources.projects

@Composable
@Preview
fun App(isPortrait:Boolean = false) {
    val currentContent = remember { mutableStateOf(0) }
    MaterialTheme {
        if(isPortrait){
            Column(Modifier.fillMaxSize()
                .background(navyBluePrimary)
                .padding(24.dp)) {
                MenuColumn(Modifier.weight(1f), {currentContent.value = it})
                ContentBox(Modifier.weight(1f), getContent(currentContent.value))
            }
        } else {
            Row (Modifier.fillMaxSize()
                .background(navyBluePrimary)
                .padding(24.dp)) {
                MenuColumn(Modifier.weight(4f), {currentContent.value = it})
                ContentBox(Modifier.weight(5f), getContent(currentContent.value))
            }
        }
    }
}

@Composable
fun getContent(code:Int): String {
    return when(code)
    { 0 -> stringResource(Res.string.about_us)
        1 -> stringResource(Res.string.experience)
        2 -> stringResource(Res.string.projects)
        else -> ""
    }
}

@Composable
fun MenuColumn(modifier: Modifier, currentContent:(Int)-> Unit){
    Column(modifier.sizeIn(maxWidth = 200.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        DescriptionText()
        MenuTextButton(currentContent)
        IconButtons({})
    }
}

@Composable
fun ContentBox(modifier: Modifier, content: String){
    Box(modifier.sizeIn(maxWidth = 200.dp)){
        Text(
            text = content,
            modifier = Modifier.padding(),
            style = MaterialTheme.typography.body1.copy(color = silverTextTitle),
            textAlign = TextAlign.Start)
    }
}