package bench.keywar.Connect

import bench.keywar.Model.SentenceModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by PaperEd on 2018-03-20.
 */
interface API {
    @POST("/single/sentence")
    @FormUrlEncoded
    fun postUserString(@FieldMap map: HashMap<String, String>) : Call<ResponseBody>

    @GET("/single/sentence")
    fun getUserString() : Call<SentenceModel>
}