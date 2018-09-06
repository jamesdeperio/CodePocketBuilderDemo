/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Item
import kotlinx.coroutines.experimental.Job

interface HasPocketSpinnerContract {
    interface Event {
        fun onSpinner2ItemSelectedEvent(item: Item)
    }

    interface ViewMethod {
        fun addItemToSpinner1(letter: String): Job
        fun addItemToSpinner2(item: Item): Job
        fun displaySelectedItem(item: Item):Job
    }

    interface Presenter {
        fun loadSpinner1Item()
        fun loadSpinner2Item()
    }
}