/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.base.PocketAdapter

@Module
object SingleVHModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideAdapter(controller: SingleVHController): SingleVHAdapter {
        val adapter = SingleVHAdapter()
        val viewHolder = SingleVHViewHolder(
                adapter = adapter,
                event = controller as HasSingleVHContract.Event)
        viewHolder.setContentView(R.layout.item_list_singlevh)
        adapter.addViewHolder(viewHolder = viewHolder)
        return adapter
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: SingleVHController, adapter: SingleVHAdapter): SingleVHView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_singlevh, controller.container, false)
        return SingleVHView(
                view = controller.rootView!!,
                event = controller as HasSingleVHContract.Event,
                context = controller.context!!,
                adapter = adapter as PocketAdapter
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: SingleVHController, view: SingleVHView): HasSingleVHContract.ViewMethod = SingleVHViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasSingleVHContract.ViewMethod, adapter: SingleVHAdapter): HasSingleVHContract.Presenter = SingleVHImpl(
            viewMethod = viewMethod,
            adapter = adapter as HasSingleVHContract.Adapter
    )


}