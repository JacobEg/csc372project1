/*
File: sortArray.kt
Authors: Jacob Egestad & Cade Marks
Description: Takes an array of ints via the command line and prints them in ascending order
Instructions: Compile via: "kotlinc sortArray.kt -d [name of jar file] -include-runtime"
Run via: java -jar [name of jar file] [integer arguments seperated by spaces]
*/

import kotlin.system.exitProcess;

fun main(args: Array<String>){
    if(args.size == 0){ // boolean operation, arguments are necessary
        System.err.println("Error: you gotta provide arguments")
        exitProcess(1)
    }
    val arr = convertToInt(args) //  function call, arr is Array<Int>
    print("Original arr: ")
    printArr(arr)
    bubbleSort(arr)
    print("Sorted arr: ")
    printArr(arr)
}

fun convertToInt(args: Array<String>): Array<Int>{
    val arr: Array<Int> = Array(args.size){0} // int array of same length as args
    var currVal = "hello" // string type
    try{
        for (i in args.indices){
            currVal = args[i]
            arr[i] = currVal.toInt()
        }
    } catch (e: NumberFormatException){
        System.err.println("Error: '" + currVal + "' can't be converted to an int");
        exitProcess(1)
    }
    return arr
}

fun bubbleSort(arr: Array<Int>){
    val end = arr.size // int type

    for(i in 0 until end-1){ // outer loop necessary for bubbleSort
        var wasSwapped = false // boolean type
        for(j in 0 until end-1){ // inner loop necessary for bubbleSort
            if(arr[j] > arr[j+1]){ // more boolean operations, if this is true swap
                wasSwapped = true
                var temp = arr[j+1] // arithmetic operations
                arr[j+1] = arr[j]
                arr[j] = temp
            }
        }

        if(!wasSwapped) // even more boolean operations, if nothing was swapped, we're done
            break
    }
}

fun printArr (arr: Array<Int>){
    for(num in arr){
        print(num.toString() + " ")
    }
    println()
}