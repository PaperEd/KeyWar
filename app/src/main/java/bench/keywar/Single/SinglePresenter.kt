package bench.keywar.Single

import bench.keywar.Model.SingleSentenceModel

/**
 * Created by PaperEd on 2018-04-17.
 */
class SinglePresenter(val view: SingleContract.View, val singleSentenceModel: SingleSentenceModel) : SingleContract.Presenter {
    var sentence: String = singleSentenceModel.getCurrentSentence()
    override fun checkSentence(userInput: String) {
        if (sentence == userInput && singleSentenceModel.index < singleSentenceModel.size) {
            setSentence()
        } else if (sentence == userInput && singleSentenceModel.index >= singleSentenceModel.size) {
//            TODO("끝내는 로직 추가하기")
            view.finishActivity()
        }
    }

    fun setSentence() {
        sentence = singleSentenceModel.getCurrentSentence()
        view.changeSentence(sentence)
        view.setSentenceCount(singleSentenceModel.index, singleSentenceModel.size)
    }
}