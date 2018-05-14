package bench.keywar.Dual

import bench.keywar.BaseView

interface DualContract {
    interface View : BaseView{

    }

    interface Presenter {
    fun connect()

    fun postUserString(sentence : String)
    }

}