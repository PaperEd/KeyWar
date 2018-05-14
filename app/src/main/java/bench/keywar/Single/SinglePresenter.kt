package bench.keywar.Single

import bench.keywar.Model.SentenceModel

/**
 * Created by PaperEd on 2018-04-17.
 */
class SinglePresenter(val view: SingleContract.View, val sentenceModel: SentenceModel) : SingleContract.Presenter {
    var sentence: String = sentenceModel.getCurrentSentence()
    override fun checkSentence(userInput: String) {
        if (sentence == userInput && sentenceModel.index < sentenceModel.size) {
            setSentence()
        } else if (sentence == userInput && sentenceModel.index >= sentenceModel.size) {
//            TODO("끝내는 로직 추가하기")
        }
    }

    fun setSentence() {
        sentence = sentenceModel.getCurrentSentence()
        view.changeSentence(sentence)
        view.setSentenceCount(sentenceModel.index, sentenceModel.size)
    }
}