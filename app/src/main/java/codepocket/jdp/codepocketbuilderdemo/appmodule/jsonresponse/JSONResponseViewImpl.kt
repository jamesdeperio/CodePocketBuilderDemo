/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class JSONResponseViewImpl(
        private val fragment: Fragment,
        private val view: JSONResponseView
) : HasJSONResponseContract.ViewMethod {
    override fun showNoConnectionDialog(): Job  = launch (UI) {
        view.noConnectionDialog.show()
    }


    override fun showLoadingDialog(): Job  = launch (UI) {
        view.loadingDialog.show()
    }


    override fun dismissLoadingDialog(): Job   = launch (UI) {
        view.loadingDialog.dismiss()
    }

    override fun printOutputResponseBody(responseBody: String): Job  = launch (UI) {
        view.tvResponse.text = responseBody
    }

    override fun printOutputPOJO(output: String):Job = launch (UI) {
        view.tvResponsePOJO.text = output
    }
}