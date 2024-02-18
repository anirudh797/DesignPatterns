package org.example

//provides some functionality before or after calling an object
//Similar to facade, except the proxy has the same interface
class `Proxy(SDP)` {
}
interface Image {
    fun display()
}

class RealImage(private val fileName : String) : Image{
    override fun display() {
        println("RealImage: Displaying $fileName")
    }

    private fun loadFromDisk(fileName: String){
        println("RealImage : Loading $fileName")
    }
    init {

        loadFromDisk(fileName)
    }

}
 class ProxyImage(private var fileName: String) : Image{
     private var realImage : RealImage? = null
     override fun display() {
         println("ProxyImage : Displaying $fileName")
         if (realImage == null) {
             realImage = RealImage(fileName)
         }
         realImage?.display()

     }

 }

class Main{
    fun main(){
        var proxyImage = ProxyImage("/anirudh")
        proxyImage.display() // first time - image will be loaded from disk and displayed
        proxyImage.display() // second time - image will be loaded directly since its already cached
    }
}