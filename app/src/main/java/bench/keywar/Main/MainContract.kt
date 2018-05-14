package bench.keywar.Main

import bench.keywar.BaseView
import bench.keywar.Model.SentenceModel

/**
 * Created by dsm2017 on 2018-04-10.
 */
interface MainContract {
    interface View : BaseView {
        fun showDialog(isSingle : Boolean)

        fun startSingleActivity(sentenceModel: SentenceModel)
    }

    interface Presenter {
        fun postUserString(sentence: String)

        fun startSinglePlay(sentenceCount: String)
    }
}