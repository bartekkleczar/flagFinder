package com.example.flagfinder

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _state = MutableStateFlow(CountryState())
    val state: StateFlow<CountryState> = _state.asStateFlow()

    private fun loadCountries(filter: CountryFilter = CountryFilter()) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                val response = RetrofitInstance.api.filterCountries(
                    red = filter.red,
                    green = filter.green,
                    blue = filter.blue,
                    yellow = filter.yellow,
                    orange = filter.orange,
                    white = filter.white,
                    black = filter.black,
                    horizontal = filter.horizontal,
                    vertical = filter.vertical,
                    diagonal = filter.diagonal,
                    centered = filter.centered,
                    triangleHorizontal = filter.triangleHorizontal,
                    other = filter.other,
                    circleSign = filter.circleSign,
                    crescentSign = filter.crescentSign,
                    crossSign = filter.crossSign,
                    starSign = filter.starSign,
                    sunSign = filter.sunSign,
                    otherSign = filter.otherSign,
                    noSigns = filter.noSigns
                )
                _state.update {
                    it.copy(
                        countries = response,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        error = e.message ?: "Unknown error",
                        isLoading = false
                    )
                }
            }
        }
    }

    private val _filterState = MutableStateFlow(CountryFilter())
    val filterState: StateFlow<CountryFilter> = _filterState.asStateFlow()

    init {
        observeFilters()
    }

    private fun observeFilters() {
        viewModelScope.launch {
            _filterState
                .debounce(300)
                .distinctUntilChanged()
                .collect { filter ->
                    loadCountries(filter)
                }
        }
    }

    fun updateFilter(newFilter: CountryFilter) {
        _filterState.value = newFilter
    }
}

data class CountryState(
    val countries: List<CountryDTO> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class CountryFilter(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
    val yellow: Int = 0,
    val orange: Int = 0,
    val white: Int = 0,
    val black: Int = 0,

    val horizontal: Int = 0,
    val vertical: Int = 0,
    val diagonal: Int = 0,
    val centered: Int = 0,
    val triangleHorizontal: Int = 0,
    val other: Int = 0,

    val circleSign: Int = 0,
    val crescentSign: Int = 0,
    val crossSign: Int = 0,
    val starSign: Int = 0,
    val sunSign: Int = 0,
    val otherSign: Int = 0,
    val noSigns: Int = 0
)