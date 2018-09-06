/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object PocketSpinnerModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: PocketSpinnerController): PocketSpinnerView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_pocketspinner, controller.container, false)
        return PocketSpinnerView(
                view = controller.rootView!!,
                event = controller as HasPocketSpinnerContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: PocketSpinnerController, view: PocketSpinnerView): HasPocketSpinnerContract.ViewMethod = PocketSpinnerViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasPocketSpinnerContract.ViewMethod): HasPocketSpinnerContract.Presenter = PocketSpinnerImpl(
            viewMethod = viewMethod
    )


}