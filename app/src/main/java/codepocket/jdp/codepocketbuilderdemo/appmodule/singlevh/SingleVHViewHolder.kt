/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh;

import android.support.v7.widget.CardView
import android.view.View
import android.widget.TextView
import codepocket.jdp.codepocketbuilderdemo.R
import jdp.pocketlib.base.PocketViewHolder

class SingleVHViewHolder(
        private val adapter: SingleVHAdapter,
        private val event: HasSingleVHContract.Event) : PocketViewHolder() {
    override fun onBindViewHolder(view: View, position: Int) {
        view.findViewById<TextView>(R.id.tvItem).text=adapter.itemFilteredList[position]
        view.findViewById<CardView>(R.id.cardContainer).setOnClickListener { event.onRowClickEvent(adapter.itemFilteredList[position]) }
    }
}
