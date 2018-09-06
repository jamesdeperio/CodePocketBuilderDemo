/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse

import codepocket.jdp.codepocketbuilderdemo.global.util.subscribeCatchRetrofitInternalError
import codepocket.jdp.codepocketbuilderdemo.integration.network.YahooWeatherRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class XMLResponseImpl(
        private val viewMethod: HasXMLResponseContract.ViewMethod,
        private val yahooWeatherRepository: YahooWeatherRepository) : HasXMLResponseContract.Presenter {
    override fun loadCurrentWeatherResponseBody(): Disposable = yahooWeatherRepository.getCurrentWeatherXMLResponseBody()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { viewMethod.printOutputResponseBody(it.string()) }
            .subscribeCatchRetrofitInternalError()

    override fun loadCurrentWeather(): Disposable = yahooWeatherRepository.getCurrentWeatherXML()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { viewMethod.printOutputPOJO(it.toString()) }
            .doOnComplete { viewMethod.dismissLoadingDialog() }
            .subscribeCatchRetrofitInternalError {
                it.printStackTrace()
                //doOnError cannot handle server error
                viewMethod.dismissLoadingDialog()
                viewMethod.showNoConnectionDialog()
            }
}