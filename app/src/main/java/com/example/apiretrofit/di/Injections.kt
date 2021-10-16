import com.example.apiretrofit.MainViewModel
import com.example.apiretrofit.NetworkHelper

import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModul = module {
    single {
        GsonBuilder()
            .setLenient()
            .create()
    }
    single {
        Retrofit.Builder()
            .baseUrl("http://test.vivian-legend.uz/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
}
val helperModul = module {
    single { NetworkHelper(get()) }
}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}