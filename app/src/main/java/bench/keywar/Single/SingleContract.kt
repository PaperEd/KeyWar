package bench.keywar.Single

import bench.keywar.BaseView
import bench.keywar.Model.SentenceModel

/**
 * Created by PaperEd on 2018-04-16.
 */
interface SingleContract {
    interface View : BaseView {
        fun setSentenceCount(index: Int, totalSentence: Int)

        fun changeSentence(sentence: String)
    }

    interface Presenter {
        fun checkSentence(userInput: String)
    }
}