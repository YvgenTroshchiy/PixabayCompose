package com.troshchii.pixabaycompose.ui.hitlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.troshchii.pixabaycompose.data.Hit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: HitsRepository
) : ViewModel() {

    private val _state: MutableStateFlow<HitListState> = MutableStateFlow(HitListState.Loading)
    val state: StateFlow<HitListState> = _state.asStateFlow()

    private val _hits = MutableStateFlow<List<Hit>>(emptyList())
    val hits: StateFlow<List<Hit>> = _hits.asStateFlow()

    init {
        reduce(HitListActions.GetHit)
    }

    private fun reduce(action: HitListActions) {
        when (action) {
            HitListActions.GetHit -> loadHits()
        }
    }

    private fun loadHits() {
        viewModelScope.launch {
            _hits.value = repository.loadHits()
        }
    }
}

sealed class HitListActions {
    object GetHit : HitListActions()
}

sealed interface HitListState {
    object Loading : HitListState
    data class Success(val data: List<Hit>) : HitListState
    data class Error(val data: Throwable) : HitListState
}
