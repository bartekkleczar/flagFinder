package com.example.flagfinder.ui.composables

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.flagfinder.CountryFilter

@Composable
fun FlagColorsChipsRow(
    filter: CountryFilter,
    onFilterChange: (CountryFilter) -> Unit
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ){
        FilterChip(
            onClick = { onFilterChange(filter.copy(red = if (filter.red == 1) 0 else 1)) },
            label = { Text("Red") },
            selected = filter.red == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Red",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.Red
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(green = if (filter.green == 1) 0 else 1)) },
            label = { Text("Green") },
            selected = filter.green == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Green",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.Green
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(blue = if (filter.blue == 1) 0 else 1)) },
            label = { Text("Blue") },
            selected = filter.blue == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Blue",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.Blue
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(yellow = if (filter.yellow == 1) 0 else 1)) },
            label = { Text("Yellow") },
            selected = filter.yellow == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Yellow",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.Yellow
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(orange = if (filter.orange == 1) 0 else 1)) },
            label = { Text("Orange") },
            selected = filter.orange == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Orange",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color(0xFFFFA500)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(white = if (filter.white == 1) 0 else 1)) },
            label = { Text("White") },
            selected = filter.white == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "White",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.White
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(black = if (filter.black == 1) 0 else 1)) },
            label = { Text("Black") },
            selected = filter.black == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Black",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.Black
                )
            }
        )
    }
}