package bench.keywar.Main

import android.util.Log
import bench.keywar.Connect.Connector
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import rx.Observable
import rx.subjects.BehaviorSubject
import rx.subjects.Subject

/**
 * Created by dsm2017 on 2018-04-10.
 */
class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    override fun getSingleString(sentenceCount: String): ArrayList<String> {
        view.showToast(sentenceCount)

        val res = Connector.api.getUserString(sentenceCount).execute().body()
        val sentences = ArrayList<String>()

        return res?.sentences?.mapTo(sentences) { it.sentence }!!

    }

    override fun postUserString(sentence: String) {
    }
}