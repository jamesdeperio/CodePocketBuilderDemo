/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.content

import android.content.Context
import android.view.View
import android.widget.Button
import codepocket.jdp.codepocketbuilderdemo.R

class ContentView(
        view: View,
        event: HasContentContract.Event,
        context: Context) {
    val btnNavigateSwipeContent = view.findViewById<Button>(R.id.btnNavigateSwipeContent)!!.apply {
        this.setOnClickListener { event.onNavigateSwipeContentClickEvent() }
    }
}