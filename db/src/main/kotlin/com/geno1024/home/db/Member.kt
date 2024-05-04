package com.geno1024.home.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class Member : Table()
{
    val id: Column<Int> = integer("id").autoIncrement()
    val role: Column<String> = varchar("role", 40)
    val name: Column<String> = varchar("name", 40)

    override val primaryKey = PrimaryKey(id, role)
}
