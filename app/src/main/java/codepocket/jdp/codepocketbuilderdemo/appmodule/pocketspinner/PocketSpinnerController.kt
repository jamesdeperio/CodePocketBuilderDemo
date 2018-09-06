/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Item
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PocketSpinnerController : DIBaseFragment(), HasPocketSpinnerContract.Event {
    @field:[Inject] internal lateinit var presenter: HasPocketSpinnerContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasPocketSpinnerContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        presenter.loadSpinner1Item()
        presenter.loadSpinner2Item()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        subscription.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    override fun onSpinner2ItemSelectedEvent(item: Item) {
        viewMethod.displaySelectedItem(item)
    }

}