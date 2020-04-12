package subtask4

class Pangram {
    val consonants = listOf('q','w','r','t','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m')
    val vowels = listOf('e','y','u','i','o','a')
    // TODO: Complete the following function
    fun analyze(inputString: String): List<String> {
        inputString.replace(" *", " ")
        val isPanagram = (consonants+vowels).map{it in inputString || it.toUpperCase() in inputString}.filter{it == true}.size == 26
        if(isPanagram) {
            var words = inputString.map { if (it in vowels) it.toUpperCase() else it }
                .joinToString(separator = "").split(" ")
            words = words.map { (it.filter { it.toLowerCase() in vowels }).length.toString() + it }
                .filter { it != "0" && it != " 0" && !("\n" in it) && it != "" }
            print(words)
            return words
        } else {
            var words = inputString.map { if (it in consonants) it.toUpperCase() else it }
                .joinToString(separator = "").split(" ")
            words =
                words.map { (it.filter { it.toLowerCase() in consonants }).length.toString() + it }
                    .filter { it != " 0" && it != "0" && !("\n" in it) && it != "" }
            print(words)
            return words
        }
    }
    fun getResult(i: String): String {
        val words = analyze(i)
        return words.sortedBy{
            it[0]-48
        }.joinToString(" ")
    }
}
