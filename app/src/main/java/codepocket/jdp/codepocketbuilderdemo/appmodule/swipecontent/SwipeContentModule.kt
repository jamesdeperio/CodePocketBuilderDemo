/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent

import android.annotation.SuppressLint
import dagger.Binds
import dagger.Module
import dagger.Provides
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable
import codepocket.jdp.codepocketbuilderdemo.R
import android.support.v4.app.Fragment
import android.content.Context
import jdp.pocketlib.base.PocketAdapter

@Module
object SwipeContentModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: SwipeContentController): SwipeContentView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_swipecontent, controller.container, false)
        return SwipeContentView(
                view = controller.rootView!!,
                event = controller as HasSwipeContentContract.Event,
                context = controller.context!!
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: SwipeContentController, view: SwipeContentView): HasSwipeContentContract.ViewMethod = SwipeContentViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasSwipeContentContract.ViewMethod): HasSwipeContentContract.Presenter = SwipeContentImpl(
            viewMethod = viewMethod
    )


}