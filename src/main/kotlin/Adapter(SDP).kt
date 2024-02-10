package org.example

//converts interface of one type to another
class `Adapter(SDP)`() {

    fun displayData(list: List<DisplayData>) {
        //display list

    }
}

interface DataConverter {
    fun convertData(list: List<DbData>): List<DisplayData>
}

class DataConvert : DataConverter { // Adapter class

    override fun convertData(list: List<DbData>): List<DisplayData> {
        return list.map {
            DisplayData(it.position, it.user)
        }
    }

}

data class DisplayData(val userdId: String, val userName: String)
data class DbData(val position: String, val user: String)
