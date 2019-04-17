package git.playground.android.di

import android.app.Application
import dagger.Module
import dagger.Provides
import git.playground.android.PlaygroundApplication
import git.playground.android.datalayer.DataModule
import git.playground.android.domain.SchedulerProvider
import git.playground.android.domain.SchedulerProviderImpl

@Module(includes = [DataModule::class])
class MainModule(private val app: PlaygroundApplication) {
    @Provides
    fun provideApplicationContext() :Application {
        return app
    }
    @Provides
    fun rxSchedulerProvier(): SchedulerProvider {
        return SchedulerProviderImpl
    }
}