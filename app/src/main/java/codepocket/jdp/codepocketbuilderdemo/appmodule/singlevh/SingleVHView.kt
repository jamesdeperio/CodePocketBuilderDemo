/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import android.content.Context
import android.support.v7.widget.SearchView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import codepocket.jdp.codepocketbuilderdemo.R
import jdp.pocketlib.base.PocketAdapter
import jdp.pocketlib.layoutmanager.PocketStaggeredLayout
import jdp.pocketlib.widget.PocketRecyclerView

class SingleVHView(
        view: View,
        event: HasSingleVHContract.Event,
        context: Context,
        adapter: PocketAdapter
){
    val recyclerView = view.findViewById<PocketRecyclerView>(R.id.recyclerView).apply {
        this.adapter=adapter
        this.layoutManager = PocketStaggeredLayout(2,StaggeredGridLayoutManager.VERTICAL)
    }

    val searchView = view.findViewById<SearchView>(R.id.searchView).apply {
        this.setOnQueryTextListener(event)
    }
}