package bench.keywar.Single

/**
 * Created by PaperEd on 2018-04-16.
 */
interface SingleContract {
    interface View {
        fun setSentenceCount(count: Int, total: Int)

        fun changeSentence(sentence: String)
    }

    interface Presenter {

    }
}