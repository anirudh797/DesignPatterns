package org.example

class `Decorator (SDP)` {
}
//make use of existing functionality to add on another functionality ( a layer above existing func)
interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine : CoffeeMachine {
    override fun makeSmallCoffee() {
        println("Making small Coffee")
    }

    override fun makeLargeCoffee() {
        println("Making Large Coffee")
    }

}

class SpecialCoffeeMachine(val coffeeMachine : CoffeeMachine) : CoffeeMachine  by coffeeMachine{ // No need to override members

    override fun makeLargeCoffee() {
        println("Making Large Special Coffee")
    }

    fun makeMilkCoffee(){ //decorator pattern
        println("SpeciaCoffeeMachine : Making small coffee")
        coffeeMachine.makeSmallCoffee()
        print("Adding milk to it")
    }

}