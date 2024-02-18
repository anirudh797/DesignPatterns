package org.example

//compose objects into tree structures
//works when the core functionality can be represented as a tree
//manipulate many objects as a single one
class `Composite(SDP)` {
}

open class Equipment(
    open val price: Int,
    val name: String
)

open class Composite(name:String) : Equipment(0,name){
    private val equipments = ArrayList<Equipment>()

    override val price: Int
        get() = equipments.sumOf { it.price }

    fun add(equipment: Equipment): Composite = apply { equipments.add(equipment) }
}

class Computer : Composite("PC")
class Processor : Equipment(100,"Processor")
class HardDrive : Equipment(250,"Hard drive")
class Memory : Composite("Memory")
class ROM : Equipment(100,"Read only memory")
class RAM : Equipment(75,"Random Access Memory")

class CompositeTest {
    fun main() {
        val memory = Memory().add(ROM()).add(RAM())
        val pc = Computer().add(memory).add(Processor()).add(HardDrive())
    }
}