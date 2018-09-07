/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PocketVPController : DIBaseFragment(), HasPocketVPContract.Event {
    @field:[Inject] internal lateinit var presenter: HasPocketVPContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasPocketVPContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        viewMethod.buildPages()
    }

    override fun onDestroy() {
        super.onDestroy()
       subscription.dispose()
    }
}