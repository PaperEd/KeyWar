package bench.keywar.Main

/**
 * Created by dsm2017 on 2018-04-10.
 */
interface MainContract {
    interface View {

    }

    interface Presenter{
        fun postUserString(sentence : String)

        fun getUserString()
    }
}