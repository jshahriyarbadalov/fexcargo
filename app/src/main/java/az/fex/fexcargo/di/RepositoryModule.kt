package az.fex.fexcargo.di

import az.fex.fexcargo.data.repository.FexRepository
import az.fex.fexcargo.data.repository.FexRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryModule {
    val repo: Module = module {
        buildRepositories()
    }

    private fun Module.buildRepositories() {
        factory { FexRepositoryImpl(get()) }
    }
}