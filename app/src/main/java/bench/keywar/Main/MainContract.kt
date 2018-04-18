package bench.keywar.Main

import bench.keywar.BaseView

/**
 * Created by dsm2017 on 2018-04-10.
 */
interface MainContract {
    interface View : BaseView {
        fun showSingleDialog()

        fun startSingleActivity(sentences: ArrayList<String>)
    }

    interface Presenter {
        fun postUserString(sentence: String)

        fun getSingleString(sentenceCount: String)
    }
}