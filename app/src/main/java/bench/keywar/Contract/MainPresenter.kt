package bench.keywar.Contract

import android.util.Log
import android.widget.Toast
import bench.keywar.Activity.PracticeActivity
import bench.keywar.Connect.Connector
import bench.keywar.Model.SentenceModel
import bench.keywar.R
import bench.keywar.R.id.textview
import kotlinx.android.synthetic.main.activity_practice.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

/**
 * Created by dsm2017 on 2018-04-10.
 */
class MainPresenter : MainContract.Presenter {

    override fun getUserString() {
        Connector.api.getUserString()
                .enqueue(object : retrofit2.Callback<SentenceModel> {
                    override fun onResponse(call: Call<SentenceModel>?, response: Response<SentenceModel>?) {
                        var userstring = response!!.body()
                        for (item in userstring!!.sentences) {

                        }
                    }

                    override fun onFailure(call: Call<SentenceModel>?, t: Throwable?) {
                    }
                })
    }

    override fun postUserString(sentence: String) {
        val map = hashMapOf("sentence" to sentence)
        Connector.api.postUserString(map)
                .enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                        if (response!!.code() == 200) {
                            Log.d("DEBUG", "success")
                        } else {
                            Log.d("DEBUG", "failed1")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        Log.d("DEBUG", "failed2")
                    }

                })
    }

}