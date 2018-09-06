/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh;

import android.view.View
import android.widget.RadioButton
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.multiplevh.ContentRadioButton
import jdp.pocketlib.base.PocketViewHolder

class MultipleVHViewHolderContentRadioButton(
        private val adapter: MultipleVHAdapter,
        private val event: HasMultipleVHContract.Event) : PocketViewHolder() {
    override fun onBindViewHolder(view: View, position: Int) {
        view.findViewById<RadioButton>(R.id.tvDesc).apply {
            this.text= (adapter.dataList[position] as ContentRadioButton).desc
            this.isChecked= (adapter.dataList[position] as ContentRadioButton).isChecked
            this.setOnClickListener {
                event.onRadioButtonClickEvent(
                    groupID = (adapter.dataList[position] as ContentRadioButton).groupID,
                    radioButtonID=(adapter.dataList[position] as ContentRadioButton).id)
                this.isChecked=true
                (adapter.dataList[position] as ContentRadioButton).isChecked=true
            }
        }
    }
}
