package org.example

class SingletonClass private constructor(){


    companion object{

        @Volatile //changes made by one thread should be immediately visible to other threads
        var instance:SingletonClass ?= null
        fun getInstance() : SingletonClass {
            instance ?: synchronized(this){
                instance ?: SingletonClass().apply {
                    instance = this
                }
            }
            return instance!!
        }
    }
}