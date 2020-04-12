package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var res = intArrayOf(1,1,0)
        var tmp = 0
        while (res[0]*res[1] < n){
            tmp = res[0]+res[1]
            res[0] = res[1]
            res[1] = tmp
        }
        if(res[0]*res[1] == n) res[2] = 1
        return res
    }
}