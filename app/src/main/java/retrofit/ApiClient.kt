package retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val url = "http://115.21.123.108:7071/"
    //private const val url = "http://192.168.0.15:7071/"

    private val gson: Gson = GsonBuilder().setLenient().create()

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient: OkHttpClient? = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            //.connectTimeout(5, TimeUnit.SECONDS)
            //.retryOnConnectionFailure(true)
            .addInterceptor(interceptor)
            .build()

    private val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    val apiservice: ApiService

    init {
        apiservice = retrofit.create(ApiService::class.java)
    }
}