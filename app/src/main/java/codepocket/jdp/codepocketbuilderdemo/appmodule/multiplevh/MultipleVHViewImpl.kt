/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MultipleVHViewImpl(
        private val fragment: Fragment,
        private val view: MultipleVHView
) : HasMultipleVHContract.ViewMethod {
    override fun showBasicDialog(title: String, selectedItem: String) :Job = launch(UI){
        view.basicDialog.title.text=title
        view.basicDialog.description.text=selectedItem
        view.basicDialog.show()
    }
}