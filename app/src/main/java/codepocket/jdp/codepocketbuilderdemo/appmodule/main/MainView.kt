/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import android.content.Context
import android.support.v4.widget.SlidingPaneLayout
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import codepocket.jdp.codepocketbuilderdemo.R
import codepocket.jdp.codepocketbuilderdemo.global.app.GlideApp
import codepocket.jdp.codepocketbuilderdemo.global.model.temp.Menu
import com.airbnb.lottie.LottieAnimationView
import jdp.pocketlib.base.PocketAdapter
import jdp.pocketlib.layoutmanager.PocketLinearLayout
import jdp.pocketlib.widget.PocketRecyclerView

class MainView(
        view: View,
        event: HasMainContract.Event,
        context: Context,
        adapter: PocketAdapter) {
    val recyclerView = view.findViewById<PocketRecyclerView>(R.id.recyclerView)!!.apply {
        this.adapter=adapter
        this.layoutManager=PocketLinearLayout(context, LinearLayout.VERTICAL,false)
    }
    val slidingPanelLayout = view.findViewById<SlidingPaneLayout>(R.id.slidingPanelLayout)!!.apply {
        this.setPanelSlideListener(event)
    }
    val navigationLayout = view.findViewById<LinearLayout>(R.id.navigationLayout)!!
    val lottieMenu = view.findViewById<LottieAnimationView>(R.id.lottieMenu)!!.apply {
        this.speed=2f
        this.setOnClickListener { event.onMenuClickEvent(menuTask= when {
            navigationLayout.visibility==View.GONE -> Menu.BACK
            slidingPanelLayout.isOpen -> Menu.CLOSE
            else -> Menu.OPEN
        }) }
    }
    val imgNavigation= view.findViewById<ImageView>(R.id.imgNavigation)!!.apply {
        GlideApp.with(context)
                .asBitmap()
                .centerCrop()
                .load(R.drawable.codepocketbuilder)
                .into(this)
    }
}