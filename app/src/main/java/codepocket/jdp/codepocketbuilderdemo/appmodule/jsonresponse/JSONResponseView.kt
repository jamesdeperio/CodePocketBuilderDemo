/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse

import android.content.Context
import android.view.View
import android.widget.TextView
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.base.BaseView
import jdp.pocketlib.widget.PocketDialog

@Suppress("UNUSED_PARAMETER")
class JSONResponseView(
        view: View,
        private val event: HasJSONResponseContract.Event,
        context: Context): BaseView(context = context) {
    val tvResponse= view.findViewById<TextView>(R.id.tvResponse)!!
    val tvResponsePOJO= view.findViewById<TextView>(R.id.tvResponsePOJO)!!
    override var noConnectionDialog: PocketDialog
        set(value) { }
        get() = super.noConnectionDialog.apply {
            this.okAction.setOnClickListener {
                dismiss()
                event.onRetryClickEvent() } }

}