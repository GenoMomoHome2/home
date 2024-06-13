package com.geno1024.home

object Configs
{
    object Db
    {
        val host = System.getProperty("home-db-host")
        val port = System.getProperty("home-db-port", "3306")
        val database = System.getProperty("home-db-database", "GenoMomoHome")
        val username = System.getProperty("home-db-username")
        val password = System.getProperty("home-db-password")
    }
}