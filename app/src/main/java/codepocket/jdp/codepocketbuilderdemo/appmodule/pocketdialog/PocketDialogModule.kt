/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object PocketDialogModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: PocketDialogController): PocketDialogView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_pocketdialog, controller.container, false)
        return PocketDialogView(
                view = controller.rootView!!,
                event = controller as HasPocketDialogContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: PocketDialogController, view: PocketDialogView): HasPocketDialogContract.ViewMethod = PocketDialogViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasPocketDialogContract.ViewMethod): HasPocketDialogContract.Presenter = PocketDialogImpl(
            viewMethod = viewMethod
    )


}