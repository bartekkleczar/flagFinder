package com.example.flagfinder.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flagfinder.CountryFilter

@Composable
fun Filters(currentFilter: CountryFilter, onFilterChange: (CountryFilter) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)){
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column{
                Text(text = "Flag colors")
                FlagColorsChipsRow(currentFilter, onFilterChange)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(text = "Layout")
                FlagLayoutChipsRow(currentFilter, onFilterChange)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(text = "Layout")
                FlagSignsChipsRow(currentFilter, onFilterChange)
            }
        }
    }
}