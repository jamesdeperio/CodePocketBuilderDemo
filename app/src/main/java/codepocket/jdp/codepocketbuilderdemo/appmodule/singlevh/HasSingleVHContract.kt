/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import android.support.v7.widget.SearchView
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.Job

interface HasSingleVHContract {
    interface Event : SearchView.OnQueryTextListener{
        @Suppress("UNUSED_EXPRESSION")
        override fun onQueryTextSubmit(query: String?): Boolean =true
        fun onRowClickEvent(rowContent: String)
    }

    interface ViewMethod {
        fun showSnackbar(rowContent: String):Job
    }

    interface Presenter {
        fun loadList(): Disposable
        fun filter(newText: String): Disposable
    }

    interface Adapter {
        fun refreshList(): Job
        fun addNewItem(item: String): Job
        fun filter(query: String): List<String>
        fun setNewFilteredList(filteredList: MutableList<String>)
    }
}