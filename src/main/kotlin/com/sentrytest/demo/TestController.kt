package com.sentrytest.demo

import io.sentry.Sentry
import io.sentry.spring.tracing.SentrySpan
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {
    @RequestMapping(value = ["test"], method = [RequestMethod.GET])
    @SentrySpan
    fun test(): String {
        try {
            throw Exception("This is a test.")
        } catch (e: Exception) {
            Sentry.captureException(e)
        }
        return "OK"
    }
}