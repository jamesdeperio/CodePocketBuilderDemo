/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog

import kotlinx.coroutines.experimental.Job

interface HasPocketDialogContract {
    interface Event {
        fun onBasicClickEvent()
        fun onWarningClickEvent()
        fun onErrorClickEvent()
        fun onSuccessClickEvent()
        fun onRewardClickEvent()
        fun onLoaderClickEvent()
        fun onNoInternetClickEvent()
    }

    interface ViewMethod {
        fun showBasicDialog(title: String, description: String):Job
        fun showWarningDialog(description: String):Job
        fun showErrorDialog(description: String):Job
        fun showSuccessDialog(description: String):Job
        fun showRewardDialog(description: String):Job
        fun showLoadingDialog():Job
        fun showNoInternetDialog():Job
        fun dismissLoadingDialog():Job
    }

    interface Presenter
}