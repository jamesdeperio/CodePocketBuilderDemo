/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import android.annotation.SuppressLint
import android.content.Context
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.ActivityScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.base.PocketAdapter
import javax.inject.Named

@Module
object MainModule {
    @ActivityScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @ActivityScope
    @Provides
    @JvmStatic
    fun provideAdapter(controller: MainController): MainAdapter {
        val adapter = MainAdapter()
        val viewHolder = MainViewHolder(
                adapter = adapter,
                event = controller as HasMainContract.Event)
        viewHolder.setContentView(R.layout.item_list_navigation)
        adapter.addViewHolder(viewHolder = viewHolder)
        return adapter
    }

    @SuppressLint("InflateParams")
    @ActivityScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: MainController, adapter: MainAdapter): MainView {
        val view = controller.layoutInflater.inflate(R.layout.activity_main, null)
        controller.setContentView(view)
        return MainView(
                view = view,
                event = controller as HasMainContract.Event,
                context = controller as Context,
                adapter = adapter as PocketAdapter
        )
    }

    @ActivityScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: MainController, view: MainView): HasMainContract.ViewMethod = MainViewImpl(
            context = controller,
            view = view,
            fragmentManager=controller.supportFragmentManager!!
    )

    @ActivityScope
    @Provides
    @Named("navigationOptions")
    @JvmStatic
    fun provideNavigationOptions(context: Context): MutableList<String> =
            context.resources.getStringArray(R.array.navigationlist).toMutableList()

    @ActivityScope
    @Provides
    @JvmStatic
    fun providePresenter(
            viewMethod: HasMainContract.ViewMethod,
            adapter: MainAdapter,
            @Named("navigationOptions") navigationOptions:MutableList<String>): HasMainContract.Presenter = MainImpl(
            viewMethod = viewMethod,
            adapter = adapter as HasMainContract.Adapter,
            navigationOptions=navigationOptions
    )


}