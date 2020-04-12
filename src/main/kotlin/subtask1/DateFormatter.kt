package subtask1
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.time.format.ResolverStyle

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val date = LocalDate.parse("$day.$month.$year"
                ,DateTimeFormatter.ofPattern("d.M.uuuu").withResolverStyle(ResolverStyle.STRICT))
            val toStringFormatter = DateTimeFormatter.ofPattern("d MMMM, EEEE", Locale("ru"))
            date.format(toStringFormatter)
        } catch (e: Exception) {
            "Такого дня не существует";
        }
    }
}
