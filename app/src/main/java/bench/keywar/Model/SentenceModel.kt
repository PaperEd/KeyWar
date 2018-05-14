package bench.keywar.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by dsm2017 on 2018-04-09.
 */

class SentenceModel {
    @SerializedName("sentence")
    lateinit var sentences: List<Sentences>

    inner class Sentences {
        var sentence: String = ""
    }

    fun getSentences(): ArrayList<String> {
        val sentences = ArrayList<String>()
        this.sentences.mapTo(sentences) { it.sentence }
        return sentences
    }
//    private val sentence = listOf<data>()
}