package codepocket.jdp.codepocketbuilderdemo.global.base

import android.annotation.SuppressLint
import android.content.Context
import jdp.pocketlib.widget.PocketDialog

open class BaseView(context: Context){
    open var warningDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_WARNING,isFullScreen = false)
    open var loadingDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_LOADER,isFullScreen = false)
    open var basicDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_BASIC,isFullScreen = false)
    open var errorDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_ERROR,isFullScreen = false)

    @SuppressLint("SetTextI18n")
    open var noConnectionDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_NO_INTERNET_CONNECTION,isFullScreen = false).apply {
        this.lottie.repeatCount=-1
        this.description.text="Cannot process request.\nPlease try again."
    }

    open var rewardDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_REWARD,isFullScreen = false)
    open var successDialog = PocketDialog(context = context,type = PocketDialog.Type.DIALOG_SUCCESS,isFullScreen = false)
}
