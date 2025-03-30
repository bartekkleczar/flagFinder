package com.example.flagfinder.ui.composables

import androidx.compose.material.icons.filled.Menu

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.CenterFocusStrong
import androidx.compose.material.icons.filled.ChangeHistory
import androidx.compose.material.icons.filled.Straight
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.example.flagfinder.CountryFilter

@Composable
fun FlagLayoutChipsRow(
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
            onClick = { onFilterChange(filter.copy(red = if (filter.horizontal == 1) 0 else 1)) },
            label = { Text("Horizontal") },
            selected = filter.horizontal == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Horizontal",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(vertical = if (filter.vertical == 1) 0 else 1)) },
            label = { Text("Vertical") },
            selected = filter.vertical == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Straight,
                    contentDescription = "Vertical",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(diagonal = if (filter.diagonal == 1) 0 else 1)) },
            label = { Text("Diagonal") },
            selected = filter.diagonal == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Straight,
                    contentDescription = "Diagonal",
                    modifier = Modifier.size(FilterChipDefaults.IconSize).rotate(135f)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(centered = if (filter.centered == 1) 0 else 1)) },
            label = { Text("Centered") },
            selected = filter.centered == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.CenterFocusStrong,
                    contentDescription = "Centered",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
        FilterChip(
            onClick = { onFilterChange(filter.copy(triangleHorizontal = if (filter.triangleHorizontal == 1) 0 else 1)) },
            label = { Text("Triangle Horizontal") },
            selected = filter.triangleHorizontal == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.ChangeHistory,
                    contentDescription = "Triangle Horizontal",
                    modifier = Modifier.size(FilterChipDefaults.IconSize).rotate(90f)
                )
            }
        )

        FilterChip(
            onClick = { onFilterChange(filter.copy(other = if (filter.other == 1) 0 else 1)) },
            label = { Text("Other") },
            selected = filter.other == 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.HelpOutline,
                    contentDescription = "Other",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )
    }
}