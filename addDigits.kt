/*
Authors: Jacob Egestad & Cade Marks
Description: Takes exactly one command line argument that is a positive integer and adds
up the digits.

*/

import kotlin.system.exitProcess

fun main(args: Array<String>){
    if(args.size == 0){ // gotta provide at least ine arg
        System.err.println("Error: must provide at least one arg")
        exitProcess(1)
    }
    val intArgs = convertToInt(args)
    printSums(intArgs, args)
}

fun convertToInt(args: Array<String>): Array<Int>{
    val arr = Array(args.size){0}
    for(i in args.indices){
        val curr = args[i].toIntOrNull()
        if(curr == null || curr < 0){ // must be an integer AND positive
            System.err.println("Error: '${args[i]}' is not a positive integer, must provide all positive ints")
            exitProcess(1)
        }
        arr[i] = curr
    }
    return arr
}

fun printSums(intArgs: Array<Int>, args: Array<String>){
    for(i in args.indices){
        println("Sum of digits in ${args[i]} = ${getSum(intArgs[i])}")
    }
}

fun getSum(arg: Int): Int{
    if(arg < 10){ // no more work to be done
        return arg
    }
    return arg % 10 + getSum(arg / 10) // arg % 10 gets last digit, arg / 10 gets the rest
}