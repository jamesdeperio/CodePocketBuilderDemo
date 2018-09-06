/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.content

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent.SwipeContentController
import jdp.pocketlib.util.Navigate
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class ContentViewImpl(
        private val fragment: Fragment,
        private val view: ContentView
) : HasContentContract.ViewMethod {
    override fun gotoSwipeContentFragment(): Job = launch(UI) {
        Navigate.using(fragmentManager = fragment.fragmentManager!!)
                .change(layoutID = R.id.mainContainer)
                .from(currentFragment = fragment)
                .to(fragmentToChange = SwipeContentController())
                .withBackStack(isBackstackEnabled = true)
                .commit()
    }
}