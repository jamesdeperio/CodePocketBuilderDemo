/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.integration.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import jdp.retrofitkit.RetrofitManager
import jdp.retrofitkit.SerializationFormatFactory
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager(context: Context) :RetrofitManager(context = context) {
    val yahooWeatherRepository = create(YahooWeatherRepository::class.java) as YahooWeatherRepository
    override fun initBaseURL(): String ="https://query.yahooapis.com/"

    override fun initCacheSize(): Int =0

    override fun initConverterFactory(): Converter.Factory = SerializationFormatFactory.Builder()
            .setJSONConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .setXMLConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(true).build()))
            .build()

    override fun initRxAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    override fun isPrintLogEnabled(): Boolean = true
}
