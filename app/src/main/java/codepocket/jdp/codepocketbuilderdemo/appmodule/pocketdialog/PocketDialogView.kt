/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog

import android.content.Context
import android.view.View
import android.widget.Button
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.base.BaseView

class PocketDialogView(
        view: View,
        event: HasPocketDialogContract.Event,
        context: Context):BaseView(context=context) {

    val btnBasic = view.findViewById<Button>(R.id.basic).apply {
        this.setOnClickListener { event.onBasicClickEvent() }
    }
    val btnWarning = view.findViewById<Button>(R.id.warning).apply {
        this.setOnClickListener { event.onWarningClickEvent() }
    }
    val btnError = view.findViewById<Button>(R.id.error).apply {
        this.setOnClickListener { event.onErrorClickEvent() }
    }
    val btnSuccess = view.findViewById<Button>(R.id.success).apply {
        this.setOnClickListener { event.onSuccessClickEvent() }
    }
    val btnReward = view.findViewById<Button>(R.id.reward).apply {
        this.setOnClickListener { event.onRewardClickEvent() }
    }
    val btnLoader = view.findViewById<Button>(R.id.loader).apply {
        this.setOnClickListener { event.onLoaderClickEvent() }
    }
    val btnNoInternet = view.findViewById<Button>(R.id.noInternet).apply {
        this.setOnClickListener { event.onNoInternetClickEvent() }
    }
}