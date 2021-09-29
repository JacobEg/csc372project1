/*
File: fibonacci.kt
Authors: Jacob Egestad & Cade Marks
Description: Takes an int via the command line and returns the fibonnaci sequence up
to and including that position. Passing in 1 will print "0", passing in 2 will print "0 1", etc
Instructions: Compile via: "kotlinc fibonacci.kt -d [name of jar file] -include-runtime"
Run via: "java -jar [name of jar file] [integer argument]"
*/

import kotlin.system.exitProcess

fun main(args: Array<String>){
    if(args.size != 1){ // must provide exactly 1 command-line arg
        System.err.println("Error: must provide exactly 1 command-line arg")
        exitProcess(1)
    }
    val intPosition = convertToInt(args[0])
    if(intPosition <= 0){ // can't have a non-positive position
        System.err.println("Error: int passed in must be positive")
        exitProcess(1)
    }
    printFib(intPosition)
}

fun convertToInt(position: String) : Int{
    try{ // easier than toIntOrNull
        val intPosition = position.toInt()
        return intPosition;
    } catch (e: NumberFormatException){
        System.err.println("Error: $position couldn't be converted to an int")
        exitProcess(1)
    }
}

fun printFib(position: Int){
    when(position){ // using when to decide base-cases of printFib
        1 -> println("0")

        2 -> println("0 1")

        else -> {
            var penultimate = 0
            var ultimate = 1
            var currPosition = 3
            print("0 1 ")
            while (currPosition <= position){ // go through curr positon
                val currVal = ultimate + penultimate
                print(currVal.toString() + " ")
                penultimate = ultimate
                ultimate = currVal
                currPosition++
            }
            println()
        }
    }
}