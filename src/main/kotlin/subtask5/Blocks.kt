package subtask5

import kotlin.reflect.KClass
import java.time.LocalDate

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        when {
            blockB == Int::class -> return blockA.map{if(it is Int) it as Int else 0}.sum()
            blockB == String::class -> return blockA.map{if(it is String) it as String else ""}.joinToString(separator="")
            blockB == java.time.LocalDate::class ->
                return blockA.map{if(it is LocalDate) it as java.time.LocalDate else LocalDate.of(1,1,1)}.sorted().reversed()[0]
                    .format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        }
        return -1
    }
}
