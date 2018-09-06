/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.content

import kotlinx.coroutines.experimental.Job

interface HasContentContract {
    interface Event {
        fun onNavigateSwipeContentClickEvent()
    }

    interface ViewMethod {
        fun gotoSwipeContentFragment():Job
    }

    interface Presenter
}