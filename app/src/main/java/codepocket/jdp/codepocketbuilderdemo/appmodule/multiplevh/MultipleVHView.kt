/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.base.BaseView
import jdp.pocketlib.base.PocketAdapter
import jdp.pocketlib.layoutmanager.PocketLinearLayout
import jdp.pocketlib.widget.PocketRecyclerView

class MultipleVHView(
        view: View,
        event: HasMultipleVHContract.Event,
        context: Context,
        adapter: PocketAdapter):BaseView(context=context){
    val recyclerView = view.findViewById<PocketRecyclerView>(R.id.recyclerView).apply {
        this.adapter = adapter
        this.layoutManager = PocketLinearLayout(context, LinearLayout.VERTICAL,false)
    }
}