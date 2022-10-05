package pl.senordeveloper.insertkoinsharedviewmodel

import androidx.lifecycle.SavedStateHandle
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(savedStateHandle = get())
    }
}
