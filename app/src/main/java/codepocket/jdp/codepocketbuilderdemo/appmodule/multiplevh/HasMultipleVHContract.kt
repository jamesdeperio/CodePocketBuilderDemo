/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.Job

interface HasMultipleVHContract {
    interface Event {
        fun onRadioButtonClickEvent(groupID: Int,radioButtonID: Int)
        fun onShowSelectedItem()
    }

    interface ViewMethod {
        fun showBasicDialog(title: String, selectedItem: String): Job
    }

    interface Presenter {
        fun loadList(): Disposable
        fun processRadioGroup(groupID: Int, radioButtonID: Int): Disposable
        fun processSelectedItem(): Disposable
    }

    interface Adapter {
        fun refreshList(): Job
        fun addNewItem(newItem:Any): Job
        fun getRadioButtonData(groupID: Int, radioButtonID: Int): MutableList<Any>
        fun getSelectedItem(): MutableList<Any>
    }
}