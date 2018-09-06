/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh;

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.multiplevh.*
import jdp.pocketlib.base.PocketAdapter
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.*

class MultipleVHAdapter : PocketAdapter(), HasMultipleVHContract.Adapter {
    var dataList: MutableList<Any> = ArrayList()

    override fun getItemCount(): Int = dataList.size

    override fun viewTypeCondition(position: Int): Int = when {
                dataList[position] is Header -> MultipleVHType.HEADER
                dataList[position] is SubTitle -> MultipleVHType.SUBTITLE
                dataList[position] is ContentText -> MultipleVHType.TEXT
                dataList[position] is ContentRadioButton -> MultipleVHType.RADIOBUTTON
                dataList[position] is ContentCheckbox -> MultipleVHType.CHECKBOX
                else -> MultipleVHType.FOOTER
    }

    override fun getRadioButtonData(groupID: Int, radioButtonID: Int): MutableList<Any> = dataList.filter { it is ContentRadioButton && it.groupID==groupID && it.id!=radioButtonID}.toMutableList()

    override fun getSelectedItem(): MutableList<Any> = dataList.filter {
        (it is ContentRadioButton && it.isChecked) || (it is ContentCheckbox && it.isChecked)
    }.toMutableList()

    override fun refreshList(): Job = launch(UI) {
        notifyDataSetChanged()
    }

    override fun addNewItem(newItem:Any): Job = launch(UI) {
        dataList.add(newItem)
        notifyItemInserted(itemCount)
    }

}
