/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.global.module.appconfig

import android.app.Application
import android.content.Context
import codepocket.jdp.codepocketbuilderdemo.global.scope.ApplicationScope
import codepocket.jdp.codepocketbuilderdemo.integration.network.NetworkManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import jdp.pocketlib.util.Bus
import jdp.pocketlib.util.EventPublisher

@Module
abstract class ApplicationBindingModule {
    @Binds internal abstract fun bindContext(application: Application): Context

    @Module
    companion object Provider {
        @ApplicationScope
        @Provides
        @JvmStatic
        fun provideEventPublisher(): EventPublisher = EventPublisher(bus = Bus.PublishSubject)

        @ApplicationScope
        @Provides
        @JvmStatic
        fun provideNetworkManager(context: Context): NetworkManager = NetworkManager(context = context)

        //todo provide dao, etc.. to inject globally
    }
}
