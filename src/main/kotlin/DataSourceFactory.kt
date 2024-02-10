package org.example

//one level of abstraction over factory method
//separation of concerns
//allows for testability
abstract class DataSourceFactory {
    abstract fun makeDataSource(): DataSource
}

class NetworkDataSourceFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource {
        return NetworkDataSource()
    }
}

class DatabaseSourceFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource {
        return NetworkDataSource()
    }
}


class dataSourceFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource {
        TODO("Not yet implemented")
    }

    companion object {
        inline fun <reified T : DataSource> createFactory(): DataSourceFactory {
            return when (T::class) {
                NetworkDataSource::class -> NetworkDataSourceFactory()
                DbDataSource::class -> DatabaseSourceFactory()
                else -> throw IllegalArgumentException()
            }
        }
    }
}


interface DataSource

class NetworkDataSource() : DataSource
class DbDataSource() : DataSource
