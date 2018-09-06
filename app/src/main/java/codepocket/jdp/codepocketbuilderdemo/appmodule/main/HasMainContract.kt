/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import android.support.v4.app.Fragment
import android.support.v4.widget.SlidingPaneLayout
import android.view.View
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Navigation
import codepocket.jdp.codepocketbuilderdemo.global.model.temp.Menu
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.coroutines.experimental.Job

interface HasMainContract {
    interface Event : SlidingPaneLayout.PanelSlideListener {
        fun onNavigationOptionClickEvent(option: String)
        fun onMenuClickEvent(menuTask: Menu)
        override fun onPanelClosed(panel: View) {}
        override fun onPanelOpened(panel: View) {}
        fun onBusReceivedEvent(): Consumer<in Any>
    }

    interface ViewMethod {
        fun closeSlidingPanel():Job
        fun openSlidingPanel(): Job
        fun setMenuProgress(progress: Float):Job
        fun removeFragment():Job
        fun disableSlidingPanel():Job
        fun enableSlidingPanel():Job
        fun gotoFragment(fragment: Fragment): Job
    }

    interface Presenter {
        fun loadNavigationOption(): Disposable
        fun computeProgressOffset(slideOffset: Float)
    }

    interface Adapter {
        fun addNewItem(navigation: Navigation): Job
        fun setNavigationIsSelectedValueAt(index: Int,value:Boolean) :Job

    }
}