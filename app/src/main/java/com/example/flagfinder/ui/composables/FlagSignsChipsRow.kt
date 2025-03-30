package com.example.flagfinder.ui.composables

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flagfinder.CountryFilter

@Composable
fun FlagSignsChipsRow(
    filter: CountryFilter,
    onFilterChange: (CountryFilter) -> Unit
){
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilterChip(
            onClick = { onFilterChange(filter.copy(circleSign = if (filter.circleSign == 1) 0 else 1)) },
            label = { Text("Circle") },
            selected = filter.circleSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Circle",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(crescentSign = if (filter.crescentSign == 1) 0 else 1)) },
            label = { Text("Crescent") },
            selected = filter.crescentSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.NightsStay,
                    contentDescription = "Crescent",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(crossSign = if (filter.crossSign == 1) 0 else 1)) },
            label = { Text("Cross") },
            selected = filter.crossSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Cross",
                    modifier = Modifier.size(FilterChipDefaults.IconSize))
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(starSign = if (filter.starSign == 1) 0 else 1)) },
            label = { Text("Star") },
            selected = filter.starSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    modifier = Modifier.size(FilterChipDefaults.IconSize))
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(sunSign = if (filter.sunSign == 1) 0 else 1)) },
            label = { Text("Sun") },
            selected = filter.sunSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.WbSunny,
                    contentDescription = "Sun",
                    modifier = Modifier.size(FilterChipDefaults.IconSize))
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(otherSign = if (filter.otherSign == 1) 0 else 1)) },
            label = { Text("Other Signs") },
            selected = filter.otherSign == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.HelpOutline,
                    contentDescription = "Other Signs",
                    modifier = Modifier.size(FilterChipDefaults.IconSize))
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(noSigns = if (filter.noSigns == 1) 0 else 1)) },
            label = { Text("No Signs") },
            selected = filter.noSigns == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Block,
                    contentDescription = "No Signs",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
    }
}