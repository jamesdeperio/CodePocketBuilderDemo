/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class JSONResponseController : DIBaseFragment(), HasJSONResponseContract.Event {
    @field:[Inject] internal lateinit var presenter: HasJSONResponseContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasJSONResponseContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        viewMethod.showLoadingDialog()
        subscription.add(presenter.loadCurrentWeatherResponseBody())
        subscription.add(presenter.loadCurrentWeather())
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    override fun onRetryClickEvent() {
        viewMethod.showLoadingDialog()
        subscription.add(presenter.loadCurrentWeatherResponseBody())
        subscription.add(presenter.loadCurrentWeather())
    }
}