/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import codepocket.jdp.codepocketbuilderdemo.R
import jdp.pocketlib.util.Navigate
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainViewImpl(
        private val context: Context,
        private val view: MainView,
        private val fragmentManager: FragmentManager
) : HasMainContract.ViewMethod {
    override fun gotoFragment(fragment: Fragment): Job = launch(UI) {
        Navigate.using(fragmentManager = fragmentManager)
                .change(layoutID = R.id.mainContainer)
                .to(fragmentToChange = fragment)
                .withBackStack(isBackstackEnabled = false)
                .commit()
    }

    override fun disableSlidingPanel(): Job = launch(UI) {
        view.navigationLayout.visibility=View.GONE
        view.lottieMenu.setAnimation(R.raw.back)
        view.lottieMenu.setMinProgress(0f)
        view.lottieMenu.speed=3f
        view.lottieMenu.setMaxProgress(0.3f)
        view.lottieMenu.repeatCount=0
        view.lottieMenu.playAnimation()
    }
    override fun enableSlidingPanel(): Job = launch(UI) {
        view.navigationLayout.visibility=View.VISIBLE
        view.lottieMenu.setAnimation(R.raw.hamburger_menu)
        view.lottieMenu.speed=2f
    }

    override fun removeFragment(): Job = launch(UI) {
        Navigate.using(fragmentManager = fragmentManager)
                .change(layoutID = R.id.mainContainer)
                .to(fragmentToChange = Fragment())
                .withBackStack(isBackstackEnabled = false)
                .commit()
    }


    override fun closeSlidingPanel(): Job = launch(UI) {
        view.slidingPanelLayout.closePane()
    }
    override fun openSlidingPanel(): Job = launch(UI) {
        view.slidingPanelLayout.openPane()
    }
    override fun setMenuProgress(progress: Float): Job = launch(UI) {
        view.lottieMenu.progress=  if (progress>=0) progress else 0f
    }
}