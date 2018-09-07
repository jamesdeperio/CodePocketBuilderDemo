/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp

import kotlinx.coroutines.experimental.Job

interface HasPocketVPContract {
    interface Event

    interface ViewMethod {
        fun buildPages():Job
    }

    interface Presenter
}