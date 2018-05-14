package bench.keywar.Connect

import bench.keywar.Model.SingleSentenceModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by PaperEd on 2018-03-20.
 */
interface API {
    @POST("/single/sentence")
    @FormUrlEncoded
    fun postUserString(@Field("sentence") sentence : String ): Call<ResponseBody>

    @GET("/single/sentence/{count}")
    fun getUserString(@Path("count") count: String): Call<SingleSentenceModel>
}