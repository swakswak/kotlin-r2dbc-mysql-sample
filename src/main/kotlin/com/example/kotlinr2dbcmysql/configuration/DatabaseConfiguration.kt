//package com.example.kotlinr2dbcmysql.configuration
//
//import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class DatabaseConfiguration(
//    @Value("\${spring.datasource.url}") private val url: String,
//    @Value("\${spring.datasource.username}") private val username: String,
//    @Value("\${spring.datasource.password}") private val password: String,
//) {
//    init {
//        val connectionFactory = MySQLConnectionFactory(
//            com.github.jasync.sql.db.Configuration(
//                host = "localhost",
//                port = 3306,
//                database = "todo_list",
//                username = "root",
//                password = "root",
//            ),
//        )
//        JasyncConnectionFactory(connectionF actory)
//    }
//}
