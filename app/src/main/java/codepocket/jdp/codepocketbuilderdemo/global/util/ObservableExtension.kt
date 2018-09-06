package codepocket.jdp.codepocketbuilderdemo.global.util

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions

fun <T> Observable<T>.subscribeCatchRetrofitInternalError(errorCallback: (error :Throwable) -> Unit= { it.printStackTrace() }): Disposable =
        subscribe(Functions.emptyConsumer<Any>(), Consumer {  errorCallback(it) }, Functions.EMPTY_ACTION, Functions.emptyConsumer<Any>())
