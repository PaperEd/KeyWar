package bench.keywar.Main

import bench.keywar.BaseView

/**
 * Created by dsm2017 on 2018-04-10.
 */
interface MainContract {

    interface View : BaseView {

        fun showDualDialog()

        fun showDialog(isSingle: Boolean)

        fun startSingleActivity(sentences: ArrayList<String>)

    }

    interface Presenter {
        fun postUserString(sentence: String)

        fun startSinglePlay(sentenceCount: String)
    }
}