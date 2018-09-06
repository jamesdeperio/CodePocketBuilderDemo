/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SingleVHController : DIBaseFragment(), HasSingleVHContract.Event {
    @field:[Inject] internal lateinit var presenter: HasSingleVHContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasSingleVHContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        subscription.add(presenter.loadList())
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    override fun onQueryTextChange(newText: String): Boolean {
        subscription.add(presenter.filter(newText))
        return true
    }

    override fun onRowClickEvent(rowContent: String) {
        viewMethod.showSnackbar(rowContent)
    }
}