package az.fex.core.utils

abstract class Mapper<T1,T2> {
   abstract fun map(value:T1):T2
}