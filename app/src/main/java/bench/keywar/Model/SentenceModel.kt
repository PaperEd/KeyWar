package bench.keywar.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by dsm2017 on 2018-04-09.
 */

class SentenceModel{
    @SerializedName("sentence")
    lateinit var sentences : List<Sentences>

    inner class Sentences{
        var sentence : String = ""
        var serial_number : String = ""
    }
//    private val sentence = listOf<data>()
}