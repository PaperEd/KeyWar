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

class DualPresenter(val view : DualContract.View) : DualContract.Presenter{
    override fun connect() {
        val sokect = IO.socket("URL")
        sokect.connect()
                .on(Socket.EVENT_CONNECT, {Emitter.Listener {
                    view.showToast("asdfsasdff")
                }})
                .on(Socket.EVENT_DISCONNECT,{view.showToast(" ")})
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
