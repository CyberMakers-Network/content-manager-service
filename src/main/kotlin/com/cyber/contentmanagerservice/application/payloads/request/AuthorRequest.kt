package com.cyber.contentmanagerservice.application.payloads.request

data class AuthorRequest(
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String
)
