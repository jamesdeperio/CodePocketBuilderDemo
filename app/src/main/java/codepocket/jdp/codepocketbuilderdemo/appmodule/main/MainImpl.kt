/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.main

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Navigation
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class  MainImpl(
        private val viewMethod: HasMainContract.ViewMethod,
        private val adapter: HasMainContract.Adapter,
        private val navigationOptions: MutableList<String>) : HasMainContract.Presenter {
    override fun computeProgressOffset(slideOffset: Float) {
        viewMethod.setMenuProgress(if (slideOffset-0.7f<0) slideOffset-0.7f *-1 else slideOffset-0.7f)
    }

    override fun loadNavigationOption(): Disposable =
            Observable.fromIterable(navigationOptions.withIndex())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.newThread())
                    .map {
                        if (it.index!=0) Navigation(name = it.value,isSelected = false)
                        else  Navigation(name = it.value,isSelected = true)
                    }
                    .doOnNext {  adapter.addNewItem(navigation = it)}
                    .subscribe()
}