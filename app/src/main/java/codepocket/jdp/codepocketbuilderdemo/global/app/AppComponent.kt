/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.global.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import codepocket.jdp.codepocketbuilderdemo.global.module.appconfig.ActivityBindingModule
import codepocket.jdp.codepocketbuilderdemo.global.module.appconfig.ApplicationBindingModule
import codepocket.jdp.codepocketbuilderdemo.global.module.appconfig.FragmentBindingModule
import codepocket.jdp.codepocketbuilderdemo.global.module.appconfig.ServiceBindingModule
import codepocket.jdp.codepocketbuilderdemo.global.module.appconfig.BroadcastReceiverBindingModule
import codepocket.jdp.codepocketbuilderdemo.global.scope.ApplicationScope

@ApplicationScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationBindingModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    ServiceBindingModule::class,
    BroadcastReceiverBindingModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    override fun inject(instance: DaggerApplication?)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
