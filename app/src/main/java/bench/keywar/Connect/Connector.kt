package bench.keywar.Connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PaperEd on 2018-03-20.
 */
object Connector {
    lateinit var api: API

    init {
        val retrofit = Retrofit.Builder().run {
            baseUrl("http://192.168.137.203:3000")
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
        api = retrofit.create(API::class.java)
    }
}