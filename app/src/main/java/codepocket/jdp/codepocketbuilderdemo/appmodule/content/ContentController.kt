/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.content

import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ContentController : DIBaseFragment(), HasContentContract.Event {
    @field:[Inject] internal lateinit var presenter: HasContentContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasContentContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    override fun onNavigateSwipeContentClickEvent() {
        viewMethod.gotoSwipeContentFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }
}