package git.playground.android.datalayer.api

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
//class ApiModule(private val dataModule: DataModule) {
class ApiModule {
    private val PRODUCTION_API_URL = HttpUrl.parse("https://api.github.com/")

    @Provides
    fun baseUrlProvider(): HttpUrl {
        return PRODUCTION_API_URL!!
    }

    @Provides
    fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder() //
            .client(client) //
            .baseUrl(baseUrl) //
            .addConverterFactory(MoshiConverterFactory.create(moshi)) //
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //
            .build()
    }

    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create<GithubService>(GithubService::class.java)
    }
}