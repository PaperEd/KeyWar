package bench.keywar.ChooseCount

import bench.keywar.Connect.Connector

/**
 * Created by PaperEd on 2018-04-17.
 */
class ChooseCountPresenter {
    fun getSingleString(sentenceCount: String): List<String>? {
        val res = Connector.api.getUserString(sentenceCount).execute().body()
        return res?.sentences?.map { it.sentence }
    }
}