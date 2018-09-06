/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog

import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PocketDialogController : DIBaseFragment(), HasPocketDialogContract.Event {
    @field:[Inject] internal lateinit var presenter: HasPocketDialogContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasPocketDialogContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable
    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }
    override fun onBasicClickEvent() {
        viewMethod.showBasicDialog(
                title="Information",
                description="This is a sample basic dialog")
    }

    override fun onWarningClickEvent() {
       viewMethod.showWarningDialog(description="Warning! You cannot undo after saving.")
    }

    override fun onErrorClickEvent() {
       viewMethod.showErrorDialog(description="Error! Something went wrong.")
    }

    override fun onSuccessClickEvent() {
        viewMethod.showSuccessDialog(description="Account has been updated.")
    }

    override fun onRewardClickEvent() {
        viewMethod.showRewardDialog(description="You've earned points for watching the ads.")
    }

    override fun onLoaderClickEvent() {
        viewMethod.showLoadingDialog()
        subscription.add(Observable.just(true)
                .delay(2,TimeUnit.SECONDS)
                .subscribe {viewMethod.dismissLoadingDialog()})
    }

    override fun onNoInternetClickEvent() {
        viewMethod.showNoInternetDialog()
    }


}