package ru.soldatov.android.cadastre.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.soldatov.android.cadastre.presentation.MainViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindNewsViewModel(viewModel: MainViewModel): ViewModel

}