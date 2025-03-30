package com.example.flagfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flagfinder.ui.theme.FlagFinderTheme
import com.example.flagfinder.ui.composables.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlagFinderTheme {
                val viewModel: CountryViewModel = viewModel()
                val state by viewModel.state.collectAsState()
                val filterState by viewModel.filterState.collectAsState()
                var currentFilter by remember { mutableStateOf(filterState) }
                LaunchedEffect(currentFilter) {
                    viewModel.updateFilter(currentFilter)
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Flag Finder") },
                        )
                    }
                ) { innerPadding ->
                    Column(Modifier.fillMaxSize().padding(innerPadding)) {
                        Filters(
                            currentFilter = currentFilter,
                            onFilterChange = { newFilter ->
                                currentFilter = newFilter
                            })
                        FlagsColumn(state.countries)
                    }
                }
            }
        }
    }
}
