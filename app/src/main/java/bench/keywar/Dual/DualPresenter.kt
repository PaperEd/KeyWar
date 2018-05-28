package bench.keywar.Dual

import android.content.Context
import android.util.Log
import android.widget.Toast
import bench.keywar.Connect.Connector
import bench.keywar.Main.MainActivity
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class DualPresenter (private val context: Context) : DualContract.Presenter{
    override fun connect() {
        val sokect = IO.socket("URL")
        sokect.connect()
                .on(Socket.EVENT_CONNECT,{ Toast.makeText(context, "connected",Toast.LENGTH_SHORT).show()
                onConnect })
                .on(Socket.EVENT_DISCONNECT,{ Toast.makeText(context, "disconnected", Toast.LENGTH_SHORT).show() })
    }

    override fun getNextString() {
        // return string
    }

    var onConnect : Emitter.Listener = object : Emitter.Listener{
        override fun call(vararg args: Any?) {

        }
    }


    override fun postUserString(sentence: String) {
        Connector.api.postUserString(sentence).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response!!.code() == 200){
                    Log.d("DEBUG","success")
                } else {
                    Log.d("DEBUG","failed - else")
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    Log.d("DEBUG","failed - network")
            }
        })

    }


}
