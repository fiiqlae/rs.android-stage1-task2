package subtask3

class Abbreviation {
    fun matchesAnyCase(c1: Char, c2: Char): Boolean {
        return (c1 == c2) || (c1 == c2.toUpperCase())
    }
    fun abbreviationFromA(a: String, b: String): String {
        val matchesLow = a.toUpperCase().map{it in b}
        val rVal = (a.asSequence() zip matchesLow.asSequence()).toList()
            .map{(s, m) -> if(m) s.toUpperCase() else ""}
            .filter{it != ""}.joinToString(separator="")
        if(rVal == b) return "YES"
        else return "NO"
    }
}