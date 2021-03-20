package com.kundikproj.hibernatesearch.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class EchoController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun echo(): String {
        counter.incrementAndGet()
        return "Search system works"
    }

}