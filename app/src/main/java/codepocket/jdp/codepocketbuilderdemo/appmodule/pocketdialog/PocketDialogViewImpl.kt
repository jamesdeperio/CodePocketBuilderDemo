/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class PocketDialogViewImpl(
        private val fragment: Fragment,
        private val view: PocketDialogView
) : HasPocketDialogContract.ViewMethod {
    override fun showBasicDialog(title: String, description: String): Job = launch(UI) {
        view.basicDialog.title.text=title
        view.basicDialog.description.text=description
        view.basicDialog.show()
    }

    override fun showWarningDialog(description: String): Job = launch(UI) {
        view.warningDialog.description.text=description
        view.warningDialog.show()
    }

    override fun showErrorDialog(description: String): Job = launch(UI) {
        view.errorDialog.description.text=description
        view.errorDialog.show()
    }

    override fun showSuccessDialog(description: String): Job= launch(UI) {
        view.successDialog.description.text=description
        view.successDialog.show()
    }

    override fun showRewardDialog(description: String): Job = launch(UI) {
        view.rewardDialog.description.text=description
        view.rewardDialog.show()
    }

    override fun showLoadingDialog(): Job = launch(UI) {
        view.loadingDialog.show()
    }

    override fun dismissLoadingDialog(): Job = launch(UI) {
        view.loadingDialog.dismiss()
    }
    override fun showNoInternetDialog(): Job= launch(UI) {
        view.noConnectionDialog.show()
    }
}