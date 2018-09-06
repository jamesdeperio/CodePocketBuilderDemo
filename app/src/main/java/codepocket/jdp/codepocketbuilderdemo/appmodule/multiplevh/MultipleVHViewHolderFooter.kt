/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh;

import android.view.View
import android.widget.TextView
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.multiplevh.Footer
import jdp.pocketlib.base.PocketViewHolder

class MultipleVHViewHolderFooter(
        private val adapter: MultipleVHAdapter,
        private val event: HasMultipleVHContract.Event) : PocketViewHolder() {
    override fun onBindViewHolder(view: View, position: Int) {
        view.findViewById<TextView>(R.id.tvDesc).text= (adapter.dataList[position] as Footer).desc
    }
}
