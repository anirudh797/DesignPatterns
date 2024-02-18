package org.example

import java.io.File

//Define a subscription mechanism
//Notify multiple objects simulataneously
//one to many relationship

class `ObserverPattern(BDP)` {
}

interface EventListener {
    fun update(eventType: String, file: File)
}

class EventManager(vararg operations: String) {
    var listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        for (operation in operations) {
            listeners[operation] = java.util.ArrayList()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val users = listeners.get(eventType)
        users?.add(listener)
    }

    fun unSubscribe(eventType: String, listener: EventListener) {
        val users = listeners.get(eventType)
        users?.remove(listener)
    }

    fun notify(eventType: String, file: File?) {
        val users = listeners[eventType]
        users?.forEach {
            if (file != null) {
                it.update(eventType, file)
            }
        }
    }
}

class Editor {
    var eventManager: EventManager

    init {
        eventManager = EventManager("Open", "Save")
    }

    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        eventManager.notify("Open", file)
    }

    fun saveFile(filePath: String) {
        file = File(filePath)
        eventManager.notify("Save", file)
    }
}

class EmailNotificationListener(private val email: String) : EventListener {
    override fun update(eventType: String, file: File) {
        println("Email to $email : Someone has performed $eventType operation with file $file")
    }

}

class LogOpenListener(private val email: String) : EventListener {
    override fun update(eventType: String, file: File) {
        println("Save to log $file : Someone has performed $eventType operation with file $file")
    }

}

//class openFile(val string : FileName)