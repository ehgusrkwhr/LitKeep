package com.dodo.litkeep.presentation.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dodo.litkeep.domain.repository.BookshelfRepository
import com.dodo.litkeep.domain.usecase.SearchBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchBookUseCase: SearchBookUseCase
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<String>>(emptyList())
    val searchResults: StateFlow<List<String>> = _searchResults.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
        performSearch(newQuery)
    }

    fun onClearSearch() {
        _searchQuery.value = ""
        _searchResults.value = emptyList()
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            if (query.isEmpty()) {
                _searchResults.value = emptyList()
                return@launch
            }
            _isLoading.value = true
            delay(1000) // Simulate a network delay
            _searchResults.value = listOf(
                "Result 1 for $query",
                "Result 2 for $query",
                "Result 3 for $query"
            )
            _isLoading.value = false
        }
    }
}