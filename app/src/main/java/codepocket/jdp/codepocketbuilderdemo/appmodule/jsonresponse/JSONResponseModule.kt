/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import codepocket.jdp.codepocketbuilderdemo.integration.network.NetworkManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object JSONResponseModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: JSONResponseController): JSONResponseView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_jsonresponse, controller.container, false)
        return JSONResponseView(
                view = controller.rootView!!,
                event = controller as HasJSONResponseContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: JSONResponseController, view: JSONResponseView): HasJSONResponseContract.ViewMethod = JSONResponseViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasJSONResponseContract.ViewMethod, networkManager: NetworkManager): HasJSONResponseContract.Presenter = JSONResponseImpl(
            viewMethod = viewMethod,
            yahooWeatherRepository=networkManager.yahooWeatherRepository
    )


}