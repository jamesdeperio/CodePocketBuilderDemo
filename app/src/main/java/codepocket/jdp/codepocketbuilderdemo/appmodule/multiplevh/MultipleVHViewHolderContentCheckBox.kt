/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh;

import android.view.View
import android.widget.CheckBox
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.multiplevh.ContentCheckbox
import jdp.pocketlib.base.PocketViewHolder

class MultipleVHViewHolderContentCheckBox(
        private val adapter: MultipleVHAdapter,
        private val event: HasMultipleVHContract.Event) : PocketViewHolder() {
    override fun onBindViewHolder(view: View, position: Int) {
        view.findViewById<CheckBox>(R.id.tvDesc).apply {
            this.text= (adapter.dataList[position] as ContentCheckbox).desc
            this.isChecked= (adapter.dataList[position] as ContentCheckbox).isChecked
            this.setOnClickListener {
                (adapter.dataList[position] as ContentCheckbox).isChecked=this.isChecked
            }
        }
    }
}
