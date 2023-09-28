package com.healthypalate.food_e_s.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.healthypalate.food_e_s.data.FoodEsRepository
import com.healthypalate.food_e_s.model.Additive
import kotlinx.coroutines.launch

class HomeViewModel(repository: FoodEsRepository) : ViewModel(){

    private var _allAdditives = mutableStateOf(listOf<Additive>())
    val allAdditives = _allAdditives
    private var _colors = mutableStateOf(listOf<Additive>())
    val colors = _colors
    init {
         viewModelScope.launch {
             _allAdditives.value = repository.getAllAdditives()
             _colors.value = repository.getCategoryItems(0)
         }
    }
}

class HomeViewModelFactory(private val repository: FoodEsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}