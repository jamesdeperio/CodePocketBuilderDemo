/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main;

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Navigation
import jdp.pocketlib.base.PocketAdapter
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.*

class MainAdapter : PocketAdapter(), HasMainContract.Adapter {
    var navigationList: MutableList<Navigation> = ArrayList()

    override fun getItemCount(): Int = navigationList.size

    override fun addNewItem(navigation: Navigation): Job = launch(UI) {
        navigationList.add(navigation)
        notifyItemInserted(itemCount)
    }


    override fun setNavigationIsSelectedValueAt(index: Int, value: Boolean): Job = launch(UI) {
        navigationList[index].isSelected=value
        notifyItemChanged(index)
    }
}
