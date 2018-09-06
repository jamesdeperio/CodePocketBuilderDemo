/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.content

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object ContentModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: ContentController): ContentView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_content, controller.container, false)
        return ContentView(
                view = controller.rootView!!,
                event = controller as HasContentContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: ContentController, view: ContentView): HasContentContract.ViewMethod = ContentViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasContentContract.ViewMethod): HasContentContract.Presenter = ContentImpl(
            viewMethod = viewMethod
    )


}