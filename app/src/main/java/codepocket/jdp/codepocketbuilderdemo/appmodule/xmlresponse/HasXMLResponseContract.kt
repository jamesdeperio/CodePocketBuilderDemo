/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse

import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.Job

interface HasXMLResponseContract {
    interface Event {
        fun onRetryClickEvent()
    }

    interface ViewMethod {
        fun printOutputPOJO(output: String): Job
        fun printOutputResponseBody(responseBody: String): Job
        fun showNoConnectionDialog():Job
        fun showLoadingDialog(): Job
        fun dismissLoadingDialog(): Job
    }

    interface Presenter {
        fun loadCurrentWeatherResponseBody(): Disposable
        fun loadCurrentWeather(): Disposable
    }
}