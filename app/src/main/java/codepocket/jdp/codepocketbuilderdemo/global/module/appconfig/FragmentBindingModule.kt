/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.global.module.appconfig

import codepocket.jdp.codepocketbuilderdemo.appmodule.content.ContentController
import codepocket.jdp.codepocketbuilderdemo.appmodule.content.ContentModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse.JSONResponseController
import codepocket.jdp.codepocketbuilderdemo.appmodule.jsonresponse.JSONResponseModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh.MultipleVHController
import codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh.MultipleVHModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog.PocketDialogController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketdialog.PocketDialogModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner.PocketSpinnerController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner.PocketSpinnerModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp.PocketVPController
import codepocket.jdp.codepocketbuilderdemo.appmodule.pocketvp.PocketVPModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh.SingleVHController
import codepocket.jdp.codepocketbuilderdemo.appmodule.singlevh.SingleVHModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent.SwipeContentController
import codepocket.jdp.codepocketbuilderdemo.appmodule.swipecontent.SwipeContentModule
import codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse.XMLResponseController
import codepocket.jdp.codepocketbuilderdemo.appmodule.xmlresponse.XMLResponseModule
import codepocket.jdp.codepocketbuilderdemo.global.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class FragmentBindingModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [ContentModule::class])
    internal abstract fun contentInjector(): ContentController

    @FragmentScope
    @ContributesAndroidInjector(modules = [SwipeContentModule::class])
    internal abstract fun swipeContentInjector(): SwipeContentController

    @FragmentScope
    @ContributesAndroidInjector(modules = [JSONResponseModule::class])
    internal abstract fun jsonResponseInjector(): JSONResponseController

    @FragmentScope
    @ContributesAndroidInjector(modules = [XMLResponseModule::class])
    internal abstract fun xmlResponseInjector(): XMLResponseController

    @FragmentScope
    @ContributesAndroidInjector(modules = [PocketDialogModule::class])
    internal abstract fun pocketDialogInjector(): PocketDialogController

    @FragmentScope
    @ContributesAndroidInjector(modules = [PocketSpinnerModule::class])
    internal abstract fun pocketSpinnerInjector(): PocketSpinnerController

    @FragmentScope
    @ContributesAndroidInjector(modules = [SingleVHModule::class])
    internal abstract fun singleVHInjector(): SingleVHController

    @FragmentScope
    @ContributesAndroidInjector(modules = [MultipleVHModule::class])
    internal abstract fun multipleVHInjector(): MultipleVHController

    @FragmentScope
    @ContributesAndroidInjector(modules = [PocketVPModule::class])
    internal abstract fun pocketVPInjector(): PocketVPController

}