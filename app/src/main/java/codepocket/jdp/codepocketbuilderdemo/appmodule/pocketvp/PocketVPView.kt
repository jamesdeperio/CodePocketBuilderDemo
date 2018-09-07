/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp

import android.content.Context
import android.view.View
import codepocket.jdp.codepocketbuilderdemo.R
import jdp.pocketlib.widget.PocketTabLayout
import jdp.pocketlib.widget.PocketViewPager

class PocketVPView(
        view: View,
        event: HasPocketVPContract.Event,
        context: Context) {
     val tabLayout = view.findViewById<PocketTabLayout>(R.id.tabLayout)!!
     val viewPager = view.findViewById<PocketViewPager>(R.id.viewPager)!!

}