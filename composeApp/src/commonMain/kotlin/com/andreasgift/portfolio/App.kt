package com.andreasgift.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andreasgift.portfolio.UI.DescriptionText
import com.andreasgift.portfolio.UI.IconButtons
import com.andreasgift.portfolio.UI.MenuTextButton
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import portfolioweb.composeapp.generated.resources.Res
import portfolioweb.composeapp.generated.resources.about_us
import portfolioweb.composeapp.generated.resources.experience
import portfolioweb.composeapp.generated.resources.projects

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {
    val screenHeight = LocalWindowInfo.current.containerSize.height
    val screenWidth = LocalWindowInfo.current.containerSize.width
    val isPortrait = screenWidth < screenHeight
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
    val scrollState = rememberScrollState()
    Box(modifier.padding(end = 24.dp)
        .sizeIn(maxWidth = 200.dp)
        .verticalScroll(scrollState)){
        Text(
            text = content,
            modifier = Modifier.padding(),
            style = MaterialTheme.typography.body1.copy(color = silverTextTitle),
            textAlign = TextAlign.Start)
    }
}