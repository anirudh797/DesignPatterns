package org.example

//used when we have multiple parameters to initialize
//impractical to build all constructors

class Phone constructor(builder: Builder) {
    var RAM: Int = 4
    var storage: Int = 500
    val name: String = ""

    init {
        this.RAM = builder.ram
        this.storage = builder.storage
    }
    class Builder {
        var ram: Int = 4
        var storage: Int = 500
        val name: String = ""

        fun setRam(r: Int) = apply { this.ram = r }
        fun setStorage(stor: Int) = apply { this.storage = stor }
        fun build() = Phone(this)
    }
}