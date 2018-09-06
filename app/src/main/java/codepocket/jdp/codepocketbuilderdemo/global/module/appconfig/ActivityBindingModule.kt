/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.global.module.appconfig

import codepocket.jdp.codepocketbuilderdemo.appmodule.main.MainController
import codepocket.jdp.codepocketbuilderdemo.appmodule.main.MainModule
import codepocket.jdp.codepocketbuilderdemo.global.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainInjector(): MainController

}