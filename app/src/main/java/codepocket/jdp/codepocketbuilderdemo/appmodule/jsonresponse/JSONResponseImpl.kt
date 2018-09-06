/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse

import codepocket.jdp.codepocketbuilderdemo.global.util.subscribeCatchRetrofitInternalError
import codepocket.jdp.codepocketbuilderdemo.integration.network.YahooWeatherRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class JSONResponseImpl(
        private val viewMethod: HasJSONResponseContract.ViewMethod,
        private val yahooWeatherRepository: YahooWeatherRepository) : HasJSONResponseContract.Presenter {
    override fun loadCurrentWeatherResponseBody(): Disposable = yahooWeatherRepository.getCurrentWeatherJSONResponseBody()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { viewMethod.printOutputResponseBody(it.string()) }
            .subscribeCatchRetrofitInternalError()

    override fun loadCurrentWeather(): Disposable  = yahooWeatherRepository.getCurrentWeatherJSON()
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