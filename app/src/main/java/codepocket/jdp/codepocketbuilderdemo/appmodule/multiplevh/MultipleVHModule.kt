/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.base.PocketAdapter

@Module
object MultipleVHModule {
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideAdapter(controller: MultipleVHController): MultipleVHAdapter {
        val adapter = MultipleVHAdapter()
        val viewHolderHeader = MultipleVHViewHolderHeader(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        val viewHolderFooter = MultipleVHViewHolderFooter(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        val viewHolderSubTitle = MultipleVHViewHolderSubTitle(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        val viewHolderContentText = MultipleVHViewHolderContentText(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        val viewHolderContentRadioButton = MultipleVHViewHolderContentRadioButton(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        val viewHolderContentCheckBox = MultipleVHViewHolderContentCheckBox(adapter = adapter, event = controller as HasMultipleVHContract.Event)
        viewHolderHeader.setContentView(R.layout.item_list_multiplevh_header)
        viewHolderFooter.setContentView(R.layout.item_list_multiplevh_footer)
        viewHolderSubTitle.setContentView(R.layout.item_list_multiplevh_subtitle)
        viewHolderContentText.setContentView(R.layout.item_list_multiplevh_contenttext)
        viewHolderContentRadioButton.setContentView(R.layout.item_list_multiplevh_contentradiobutton)
        viewHolderContentCheckBox.setContentView(R.layout.item_list_multiplevh_contentcheckbox)
        adapter.addViewHolder(viewHolder = viewHolderHeader) // itemtype index 0
        adapter.addViewHolder(viewHolder = viewHolderFooter) // itemtype index 1
        adapter.addViewHolder(viewHolder = viewHolderSubTitle) // itemtype index 2
        adapter.addViewHolder(viewHolder = viewHolderContentText) // itemtype index 3
        adapter.addViewHolder(viewHolder = viewHolderContentRadioButton) // itemtype index 4
        adapter.addViewHolder(viewHolder = viewHolderContentCheckBox) // itemtype index 5
        return adapter
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: MultipleVHController, adapter: MultipleVHAdapter): MultipleVHView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_multiplevh, controller.container, false)
        return MultipleVHView(
                view = controller.rootView!!,
                event = controller as HasMultipleVHContract.Event,
                context = controller.context!!,
                adapter = adapter as PocketAdapter
        )
    }

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: MultipleVHController, view: MultipleVHView): HasMultipleVHContract.ViewMethod = MultipleVHViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasMultipleVHContract.ViewMethod, adapter: MultipleVHAdapter): HasMultipleVHContract.Presenter = MultipleVHImpl(
            viewMethod = viewMethod,
            adapter = adapter as HasMultipleVHContract.Adapter
    )


}