package bench.keywar.Main

import bench.keywar.BaseView
import bench.keywar.Model.SingleSentenceModel

/**
 * Created by dsm2017 on 2018-04-10.
 */
interface MainContract {

    interface View : BaseView {

        fun showDualDialog()

        fun showDialog(isSingle: Boolean)

        fun startSingleActivity(singleSentenceModel: SingleSentenceModel)
    }

    interface Presenter {
        fun postUserString(sentence: String)

        fun startSinglePlay(sentenceCount: String)
    }
}