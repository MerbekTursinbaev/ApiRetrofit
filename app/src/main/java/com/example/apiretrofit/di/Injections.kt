import com.example.apiretrofit.MainViewModel
import com.example.apiretrofit.retrofit.ApiInterface

import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
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
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ApiInterface::class.java) }

}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}