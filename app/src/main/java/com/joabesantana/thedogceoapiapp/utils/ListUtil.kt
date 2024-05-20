package com.joabesantana.thedogceoapiapp.utils

class ListUtil {
    companion object {

        fun <T> getConcatResults(oldData: MutableList<T>, newData: MutableList<T>): MutableList<T> {
            val results: MutableList<T> = ArrayList()
            results.addAll(oldData)
            results.addAll(newData)
            return results
        }
    }
}