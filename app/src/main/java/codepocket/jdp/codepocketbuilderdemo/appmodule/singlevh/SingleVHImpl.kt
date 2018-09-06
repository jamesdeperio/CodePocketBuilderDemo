/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SingleVHImpl(
        private val viewMethod: HasSingleVHContract.ViewMethod,
        private val adapter: HasSingleVHContract.Adapter
) : HasSingleVHContract.Presenter {
    override fun filter(newText: String): Disposable = Observable.just(adapter.filter(newText))
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.newThread())
                    .doOnNext { adapter.setNewFilteredList(it.toMutableList()) }
                    .doOnComplete { adapter.refreshList() }
                    .subscribe()

    override fun loadList(): Disposable = Observable.fromIterable((1 until 1000))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { adapter.addNewItem(it.toString()) }
            .doOnComplete {  }
            .subscribe()
}