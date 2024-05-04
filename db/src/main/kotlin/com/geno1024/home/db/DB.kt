package com.geno1024.home.db

import com.geno1024.home.Configs
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object DB
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        Database.connect(
            url = "jdbc:mariadb://${Configs.Db.host}:${Configs.Db.port}/${Configs.Db.database}",
            driver = "org.mariadb.jdbc.Driver",
            user = Configs.Db.username,
            password = Configs.Db.password)
        transaction {
            addLogger(StdOutSqlLogger)
        }
    }
}
