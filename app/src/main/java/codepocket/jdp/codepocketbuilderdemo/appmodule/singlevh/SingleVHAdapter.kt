/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh;

import jdp.pocketlib.base.PocketAdapter
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.*

class SingleVHAdapter : PocketAdapter(), HasSingleVHContract.Adapter {
    var itemList: MutableList<String> = ArrayList()
    var itemFilteredList: MutableList<String> = itemList

    override fun getItemCount(): Int = itemFilteredList.size

    override fun refreshList(): Job = launch(UI) {
        notifyDataSetChanged()
    }

    override fun setNewFilteredList(filteredList: MutableList<String>) {
        this.itemFilteredList=filteredList
    }

    override fun addNewItem(item: String): Job = launch(UI) {
        itemFilteredList.add(item)
        notifyItemInserted(itemCount)
    }

    override fun filter(query: String): List<String> {
        val filteredList = ArrayList<String>()
        itemList
                .filter { it.toLowerCase().contains(query.toLowerCase()) }
                .forEach { filteredList.add(it) }
        return filteredList
    }
}
