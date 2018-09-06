/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.widget.Button
import android.widget.TextView
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Item
import jdp.pocketlib.widget.PocketSpinnerDialog


class PocketSpinnerView(
        view: View,
        event: HasPocketSpinnerContract.Event,
        context: Context) {
    companion object Properties {
        init { AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); }
    }

    private val img = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        context.resources.getDrawable(R.drawable.ic_arrow_drop_down_black_24dp,null)!!
    else context.resources.getDrawable(R.drawable.ic_arrow_drop_down_black_24dp)!!

    val tvItem= view.findViewById<TextView>(R.id.tvItem)!!

    val btnSpinner1= view.findViewById<Button>(R.id.btnSpinner1).apply {
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null)
      }!!

    val btnSpinner2= view.findViewById<Button>(R.id.btnSpinner2).apply {
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null)
    }!!

    val searchableDialog2= PocketSpinnerDialog<Item>(context=context).apply {
        this.setButtonAsSpinner(btnSpinner2)
        this.setOnItemSelectedListener { selectedObject, _, _, _ ->
            event.onSpinner2ItemSelectedEvent(selectedObject)
        }
    }

    val searchableDialog1= PocketSpinnerDialog<String>(context=context).apply {
        this.setButtonAsSpinner(btnSpinner1)
    }

}