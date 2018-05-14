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

    override fun startSinglePlay(sentenceCount: String) {
        view.showToast(sentenceCount)
        Connector.api.getUserString(sentenceCount).enqueue(object : Callback<SentenceModel> {
            override fun onResponse(call: Call<SentenceModel>?, response: Response<SentenceModel>?) {
                if (response?.isSuccessful!!) {
                    val res: SentenceModel? = response.body()
                    view.startSingleActivity(res!!)
                } else {
                    view.showToast("문장을 받아오는데 실패하였습니다.")
                }
            }

            override fun onFailure(call: Call<SentenceModel>?, t: Throwable?) {
                view.showToast("인터넷 연결 상태를 확인해주세요.")
            }

        })
    }

    override fun postUserString(sentence: String) {
    }
}