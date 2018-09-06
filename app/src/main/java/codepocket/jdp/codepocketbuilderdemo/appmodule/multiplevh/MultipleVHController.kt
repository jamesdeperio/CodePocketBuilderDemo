/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MultipleVHController : DIBaseFragment(), HasMultipleVHContract.Event {
    @field:[Inject] internal lateinit var presenter: HasMultipleVHContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasMultipleVHContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        subscription.add(presenter.loadList())
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    override fun onRadioButtonClickEvent(groupID: Int,radioButtonID: Int) {
        subscription.add(presenter.processRadioGroup(groupID,radioButtonID))
    }

    override fun onShowSelectedItem() {
        subscription.add(presenter.processSelectedItem())
    }
}