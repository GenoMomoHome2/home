package com.geno1024.home.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Anniversary : Table()
{
    val id: Column<Int> = integer("id").autoIncrement()
    val date: Column<LocalDateTime> = datetime("date")
    val event: Column<String> = varchar("event", 160)
}
