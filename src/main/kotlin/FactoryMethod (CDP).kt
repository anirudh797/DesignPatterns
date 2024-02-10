package org.example

//way to access a functionality without caring about its implementation
// separation of concern
//allows testability
class `FactoryMethod (CDP)` {

    fun getCurrency(name:String) {
        val currency  = CurrencyFactory.getCurrency(name).getCurrency()
    }
}

object CurrencyFactory{

    fun getCurrency(name: String) : Currency{
        return when(name){
            "India" -> Dollar()
            "Switzerland"-> Euro()
            else -> {
                Dollar()
            }
        }
    }
}

interface Currency{
    fun getCurrency() : String
}

class Dollar : Currency{
    override fun getCurrency(): String {
        return "Dollar"
    }
}

class Rupee : Currency{
    override fun getCurrency(): String {
        return "Rupee"
    }
}

class Euro : Currency{
    override fun getCurrency(): String {
        return "Euro"
    }
}