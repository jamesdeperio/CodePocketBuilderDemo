/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent

import android.content.Context
import android.support.v4.app.Fragment

class SwipeContentViewImpl(
        private val fragment: Fragment,
        private val view: SwipeContentView
) : HasSwipeContentContract.ViewMethod