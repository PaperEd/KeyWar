package bench.keywar.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by dsm2017 on 2018-04-09.
 */

@SuppressWarnings("serial")
class SingleSentenceModel : Serializable {
    @SerializedName("sentence")
    lateinit var sentences: List<Sentences>

    var size = sentences.size

    var index = 0

    inner class Sentences {
        var sentence: String = ""
    }

    fun getCurrentSentence(): String {
        return sentences[index++].sentence
    }

    fun getSentences(): ArrayList<String> {
        val sentences = ArrayList<String>()
        this.sentences.mapTo(sentences) { it.sentence }
        return sentences
    }

//    private val sentence = listOf<data>()
}