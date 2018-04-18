package bench.keywar.Main

import bench.keywar.Connect.Connector
import bench.keywar.Model.SentenceModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by dsm2017 on 2018-04-10.
 */
class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    override fun getSingleString(sentenceCount: String) {
        view.showToast(sentenceCount)
        var res: SentenceModel?
        Connector.api.getUserString(sentenceCount).enqueue(object : Callback<SentenceModel> {
            override fun onResponse(call: Call<SentenceModel>?, response: Response<SentenceModel>?) {
                if (response?.isSuccessful!!) {
                    res = response.body()
                    val sentences = arrayListOf<String>()
                    res?.sentences!!.mapTo(sentences) { it.sentence }
                    view.startSingleActivity(sentences)
                } else {
                    view.showToast("문장을 받아오는데 실패하였습니다.")
                }
            }

            override fun onFailure(call: Call<SentenceModel>?, t: Throwable?) {
                view.showToast("문장을 받아오는데 실패하였습니다.")
            }

        })
    }

    override fun postUserString(sentence: String) {
    }
}