package bench.keywar.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import bench.keywar.Connect.Connector
import bench.keywar.Contract.MainContract
import bench.keywar.Contract.MainPresenter
import bench.keywar.Model.SentenceModel
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_practice.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by dsm2017 on 2018-04-02.
 */
class PracticeActivity : AppCompatActivity() , MainContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

//        button.setOnClickListener { postUserString(edittext.text.toString()) }

//        button2.setOnClickListener { getUserString() }
    }

}




