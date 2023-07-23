package com.example.kotlinr2dbcmysql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
class KotlinR2dbcMysqlSampleApplication

fun main(args: Array<String>) {
    runApplication<KotlinR2dbcMysqlSampleApplication>(*args)
}
