/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Item
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class PocketSpinnerViewImpl(
        private val fragment: Fragment,
        private val view: PocketSpinnerView
) : HasPocketSpinnerContract.ViewMethod {
    @SuppressLint("SetTextI18n")
    override fun displaySelectedItem(item: Item): Job = launch(UI) {
        view.tvItem.text= "ID: ${item.id} \nNAME: ${item.itemName} \nDESC:${item.itemDesc}"
    }

    override fun addItemToSpinner2(item: Item): Job = launch(UI) {
        view.searchableDialog2.addItem(itemObject = item,itemString = item.itemName!!)
    }

    override fun addItemToSpinner1(letter: String) :Job = launch(UI) {
        view.searchableDialog1.addItem(letter)
    }
}