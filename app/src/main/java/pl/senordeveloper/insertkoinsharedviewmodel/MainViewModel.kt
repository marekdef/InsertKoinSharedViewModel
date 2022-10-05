package pl.senordeveloper.insertkoinsharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _random = MutableLiveData<Int>()
    val random: LiveData<Int> = _random

    fun random() {
        _random.value = Random.nextInt()
    }
}