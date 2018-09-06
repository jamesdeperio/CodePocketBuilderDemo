package codepocket.jdp.codepocketbuilderdemo.integration.network

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.json.YahooWeatherJSON
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml.YahooWeatherXML
import io.reactivex.Observable
import jdp.retrofitkit.JSONFormat
import jdp.retrofitkit.XMLFormat
import okhttp3.ResponseBody
import retrofit2.http.*

interface YahooWeatherRepository {
    @POST("v1/public/yql")
    @FormUrlEncoded
    @Streaming
    @JSONFormat
    fun getCurrentWeatherJSON(
            @Field("q") query: String = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"manila, ph\")",
            @Field("format") format: String = "json",
            @Field("env") env: String = "store://datatables.org/alltableswithkeys"
    ):Observable<YahooWeatherJSON>

    @GET("v1/public/yql")
    @JSONFormat
    fun getCurrentWeatherJSONResponseBody(
            @Query("q") query: String = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"manila, ph\")",
            @Query("format") format: String = "json",
            @Query("env") env: String =  "store://datatables.org/alltableswithkeys"
    ):Observable<ResponseBody>

    @POST("v1/public/yql")
    @FormUrlEncoded
    @Streaming
    @XMLFormat
    fun getCurrentWeatherXML(
            @Field("q") query: String = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"manila, ph\")",
            @Field("format") format: String = "xml",
            @Field("env") env: String =  "store://datatables.org/alltableswithkeys"
    ):Observable<YahooWeatherXML>

    @GET("v1/public/yql")
    @XMLFormat
    fun getCurrentWeatherXMLResponseBody(
            @Query("q") query: String = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"manila, ph\")",
            @Query("format") format: String = "xml",
            @Query("env") env: String = "store://datatables.org/alltableswithkeys"
    ):Observable<ResponseBody>

}
