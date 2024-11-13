package com.andreasgift.portfolio.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andreasgift.portfolio.grayText
import com.andreasgift.portfolio.silverTextTitle

@Composable
fun DescriptionText() {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text("Andrea Liu", style = MaterialTheme.typography.h4.copy(color = silverTextTitle),
            modifier = Modifier.padding(bottom = 2.dp))
        Text(
            "Kotlin Multiplatform Developer", style = MaterialTheme.typography.subtitle1.copy(
                silverTextTitle
            )
        )
        Text(
            "I build app in various platform with less effort",
            style = MaterialTheme.typography.body1.copy(color = grayText)
        )
    }
}