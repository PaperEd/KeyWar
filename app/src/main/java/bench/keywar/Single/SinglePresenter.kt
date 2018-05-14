package bench.keywar.Single

import bench.keywar.Model.SentenceModel

/**
 * Created by PaperEd on 2018-04-17.
 */
class SinglePresenter(val view: SingleContract.View, val sentenceModel: SentenceModel) : SingleContract.Presenter {
    lateinit var sentence: String
    override fun checkSentence(userInput: String) {
        if (sentence == userInput) {
            sentence = sentenceModel.getCurrentSentence()
            view.changeSentence(sentence)
            view.setSentenceCount(sentenceModel.size, sentenceModel.index)
        }
    }

    override fun setSentencesModel(sentenceModel: SentenceModel) {
//        this.sentenceModel = sentenceModel
//        sentence = sentenceModel.getCurrentSentence()
    }
}