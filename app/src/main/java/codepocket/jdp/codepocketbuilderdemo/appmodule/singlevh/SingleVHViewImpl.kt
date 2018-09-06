/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class SingleVHViewImpl(
        private val fragment: Fragment,
        private val view: SingleVHView
) : HasSingleVHContract.ViewMethod {
    override fun showSnackbar(rowContent: String): Job = launch(UI) {
        Snackbar.make(fragment.view!!,rowContent,Snackbar.LENGTH_SHORT).show()
    }
}