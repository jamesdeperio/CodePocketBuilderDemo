/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseSwipeFragment
import codepocket.jdp.codepocketbuilderdemo.global.model.event.SlidingPanelConfig
import codepocket.jdp.codepocketbuilderdemo.integration.bus.EventBus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class SwipeContentController : DIBaseSwipeFragment(), HasSwipeContentContract.Event {
    @field:[Inject] internal lateinit var presenter: HasSwipeContentContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasSwipeContentContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable
    @field:[Inject] internal lateinit var eventBus: EventBus<PublishSubject<Any>>

    override fun onLoadEvent(savedInstanceState: Bundle?) {
        eventBus.sendEvent(SlidingPanelConfig(task = "DISABLE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        eventBus.sendEvent(SlidingPanelConfig(task = "ENABLE"))
        subscription.dispose()
    }
}