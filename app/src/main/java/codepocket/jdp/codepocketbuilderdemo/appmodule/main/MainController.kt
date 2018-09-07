/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import android.os.Bundle
import android.view.View
import codepocket.jdp.codepocketbuilderdemo.appmodule.content.ContentController
import codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse.JSONResponseController
import codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh.MultipleVHController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog.PocketDialogController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner.PocketSpinnerController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp.PocketVPController
import codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh.SingleVHController
import codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse.XMLResponseController
import codepocket.jdp.codepocketbuilderdemo.global.base.DIBaseActivity
import codepocket.jdp.codepocketbuilderdemo.global.model.event.SlidingPanelConfig
import codepocket.jdp.codepocketbuilderdemo.global.model.temp.Menu
import codepocket.jdp.codepocketbuilderdemo.integration.bus.EventBus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainController : DIBaseActivity(), HasMainContract.Event {
    @field:[Inject] internal lateinit var presenter: HasMainContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasMainContract.ViewMethod
    @field:[Inject] internal lateinit var subscription: CompositeDisposable
    @field:[Inject] internal lateinit var eventBus: EventBus<PublishSubject<Any>>

    override fun onBusReceivedEvent(): Consumer<in Any> = Consumer {
        if (it is SlidingPanelConfig && it.task=="DISABLE")
            viewMethod.disableSlidingPanel()
        else if (it is SlidingPanelConfig && it.task=="ENABLE")
            viewMethod.enableSlidingPanel()
    }
    override fun initialization(savedInstanceState: Bundle?) {
        eventBus.subscribeReceiver(onBusReceivedEvent())
    }
    override fun onLoadEvent(savedInstanceState: Bundle?) {
        subscription.add(presenter.loadNavigationOption())
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
        eventBus.unSubscribeReceiver()
    }

    override fun onMenuClickEvent(menuTask: Menu) {
        when(menuTask) {
            Menu.BACK -> onBackPressed()
            Menu.CLOSE-> viewMethod.closeSlidingPanel()
            Menu.OPEN->  viewMethod.openSlidingPanel()
        }
    }
    override fun onNavigationOptionClickEvent(option: String) {
        viewMethod.closeSlidingPanel()
        when (option){
            "BaseActivity"-> viewMethod.removeFragment()
            "Fragment"-> viewMethod.gotoFragment(ContentController())
            "JSON Response"->viewMethod.gotoFragment(JSONResponseController())
            "XML Response"->viewMethod.gotoFragment(XMLResponseController())
            "PocketDialog"->viewMethod.gotoFragment(PocketDialogController())
            "PocketSpinnerDialog"->viewMethod.gotoFragment(PocketSpinnerController())
            "RecyclerView - Single Viewholder"->viewMethod.gotoFragment(SingleVHController())
            "RecyclerView - Multiple Viewholder"->viewMethod.gotoFragment(MultipleVHController())
            "PocketViewPager"->viewMethod.gotoFragment(PocketVPController())
        }
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {
        presenter.computeProgressOffset(slideOffset)
    }


}