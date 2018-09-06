/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main;

import android.graphics.Color
import android.support.v7.widget.CardView
import android.view.View
import android.widget.TextView
import codepocket.jdp.codepocketbuilderdemo.R
import jdp.pocketlib.base.PocketViewHolder

class MainViewHolder(
        private val adapter: MainAdapter,
        private val event: HasMainContract.Event) : PocketViewHolder() {
    private var lastSelectedPosition= 0

    override fun onBindViewHolder(view: View, position: Int) {
        view.findViewById<CardView>(R.id.cardContainer).apply {
            if (adapter.navigationList[position].isSelected){
                this.setCardBackgroundColor(Color.WHITE)
                this.setOnClickListener(null)
            }
            else {
                this.setCardBackgroundColor(Color.parseColor("#041531"))
                this.setOnClickListener {
                    adapter.setNavigationIsSelectedValueAt(index=lastSelectedPosition,value = false)
                    adapter.setNavigationIsSelectedValueAt(index=position,value = true)
                    lastSelectedPosition=position
                    event.onNavigationOptionClickEvent(adapter.navigationList[position].name) }
            }
        }

        view.findViewById<TextView>(R.id.tvTitle).apply {
            this.text = adapter.navigationList[position].name
            this.setTextColor(
                    if (adapter.navigationList[position].isSelected)Color.BLACK
                    else Color.WHITE
            )

        }

    }


}
