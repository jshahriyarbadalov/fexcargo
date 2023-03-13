package az.fex.core.utils

import kotlinx.coroutines.flow.Flow

abstract class UseCase<P,R> {
    protected abstract fun execute(params: P): Flow<R>
    operator fun invoke(params: P):Flow<R> = execute(params)
}