package org.example

import org.jetbrains.annotations.TestOnly

//Ex:ShapeColor - Here 2 attributes are present so number of variation of classes possible could be
// BlueCircle, RedCircle, GreenSquare,RedSquare, so having a interface in this manner is not feasible,
//instead we can have a shape class which will be having color as a member variable, splits characteristics
//into different classes and bridge them with a relationship, helps to scale things if required

class `Bridge (SDP)` {

}

interface Device{
    var volume:Int
    fun getName():String
}

class Radio() : Device {
    override var volume: Int = 0
    override fun getName(): String {
        return "Radio"
    }

}

class TV() : Device {
    override var volume: Int = 0
    override fun getName(): String {
        return "TV"
    }
}

interface Remote{
    fun volUp()
    fun volDown()
}

class BasicRemote(val device: Device) : Remote{
    override fun volUp() {
        device.volume++;
    }

    override fun volDown() {
        device.volume--;
    }

}

class BridgeTest{

//    fun
}
