/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import codepocket.jdp.codepocketbuilderdemo.integration.network.NetworkManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object XMLResponseModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: XMLResponseController): XMLResponseView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_xmlresponse, controller.container, false)
        return XMLResponseView(
                view = controller.rootView!!,
                event = controller as HasXMLResponseContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: XMLResponseController, view: XMLResponseView): HasXMLResponseContract.ViewMethod = XMLResponseViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasXMLResponseContract.ViewMethod,networkManager: NetworkManager): HasXMLResponseContract.Presenter = XMLResponseImpl(
            viewMethod = viewMethod,
            yahooWeatherRepository = networkManager.yahooWeatherRepository
    )


}