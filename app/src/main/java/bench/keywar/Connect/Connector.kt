package bench.keywar.Connect

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





/**
 * Created by PaperEd on 2018-03-20.
 */
object Connector {
    lateinit var api: API

    init {
        val httpClient = OkHttpClient.Builder()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.137.203:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        api = retrofit.create(API::class.java)
    }


    private val httpClient = OkHttpClient.Builder()
}