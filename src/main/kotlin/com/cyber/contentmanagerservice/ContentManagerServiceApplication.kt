package com.cyber.contentmanagerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContentManagerServiceApplication

fun main(args: Array<String>) {
    runApplication<ContentManagerServiceApplication>(*args)
}
