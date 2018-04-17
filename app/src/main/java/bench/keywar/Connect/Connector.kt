package bench.keywar.Connect

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

//    fun call(api: Call<Any>) : Response<Any>{
//        api.execute(object : Call<Any> {
//            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
//                var res = response?.body()
//
//            }
//
//            override fun onFailure(call: Call<Any>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })
//    }
}