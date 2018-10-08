/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent

import android.os.Bundle
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseSwipeFragment
import codepocket.jdp.codepocketbuilderdemo.global.model.event.SlidingPanelConfig
import codepocket.jdp.codepocketbuilderdemo.global.util.ChannelID
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.util.EventPublisher
import javax.inject.Inject

class SwipeContentController : DIBaseSwipeFragment(), HasSwipeContentContract.Event {
    @field:[Inject] internal lateinit var presenter: HasSwipeContentContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasSwipeContentContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable
    @field:[Inject] internal lateinit var eventPublisher: EventPublisher

    override fun initialization(savedInstanceState: Bundle?) {
        eventPublisher.sendEvent(ChannelID.MENU,SlidingPanelConfig(task = "DISABLE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        eventPublisher.sendEvent(ChannelID.MENU,SlidingPanelConfig(task = "ENABLE"))
        subscription.dispose()
    }
}