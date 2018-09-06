/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class XMLResponseViewImpl(
        private val fragment: Fragment,
        private val view: XMLResponseView
) : HasXMLResponseContract.ViewMethod {
    override fun printOutputResponseBody(responseBody: String): Job = launch (UI) {
        view.tvResponse.text = responseBody
    }

    override fun printOutputPOJO(output: String): Job = launch (UI) {
        view.tvResponsePOJO.text = output
    }

    override fun showNoConnectionDialog(): Job  = launch (UI) {
        view.noConnectionDialog.show()
    }


    override fun showLoadingDialog(): Job  = launch (UI) {
        view.loadingDialog.show()
    }


    override fun dismissLoadingDialog(): Job   = launch (UI) {
        view.loadingDialog.dismiss()
    }

}