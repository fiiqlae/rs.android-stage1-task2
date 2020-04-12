package subtask2

class TimeConverter {
    private val tensNames = arrayOf(
        "", "ten", "twenty", "thirty", "forty", "fifty"
    )
    private val numNames = arrayOf(
        "", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
        "quarter", "sixteen", "seventeen", "eighteen", "nineteen"
    )
    fun toTextFormat(hour: String, minute: String): String {
        val hr = hour.toInt()
        var min = minute.toInt()
        val minQuantifier = if(min == 30 || min == 15 || min == 45) ""
        else (if(min > 1) "minutes" else "minute")
        try {
            var textHour = numNames[hr]
            var halveMsg = "to"
            if (min <= 30) halveMsg = "past"
            else {
                min = 60 - min
                textHour = numNames[hr + 1]
            }
            return (when {
                min == 0 -> "$textHour o' clock"
                min > 0 && min <= 19 -> numNames[min]+" $minQuantifier $halveMsg $textHour"
                min == 30 -> "half past $textHour"
                min >= 20 -> (tensNames[min / 10] + " " + numNames[min % 10])+" $minQuantifier $halveMsg $textHour"
                else -> ""
            }).replace(" +".toRegex(), " ")
        } catch (e: java.lang.Exception) {
            return ""
        }
    }
}