/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp

import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh.MultipleVHController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog.PocketDialogController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner.PocketSpinnerController
import codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh.SingleVHController
import jdp.pocketlib.builder.PageBuilder
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class PocketVPViewImpl(
        private val fragment: Fragment,
        private val view: PocketVPView
) : HasPocketVPContract.ViewMethod {
    override fun buildPages(): Job = launch(UI) {
        PageBuilder.build {
            this.setTabLayout(view.tabLayout)
            this.setViewPager(view.viewPager)
            this.setFragmentManager(fragment.childFragmentManager)
            this.addPage("Single ViewHolder",SingleVHController())
            this.addPage("Multiple ViewHolder",MultipleVHController())
            this.addPage("PocketDialog",PocketDialogController())
            this.addPage("PocketSpinnerDialog",PocketSpinnerController())
        }
    }
}