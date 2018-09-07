/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object PocketVPModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: PocketVPController): PocketVPView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_pocketvp, controller.container, false)
        return PocketVPView(
                view = controller.rootView!!,
                event = controller as HasPocketVPContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: PocketVPController, view: PocketVPView): HasPocketVPContract.ViewMethod = PocketVPViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasPocketVPContract.ViewMethod): HasPocketVPContract.Presenter = PocketVPImpl(
            viewMethod = viewMethod
    )


}