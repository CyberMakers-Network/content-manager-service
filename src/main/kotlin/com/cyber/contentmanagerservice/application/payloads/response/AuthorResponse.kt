package com.cyber.contentmanagerservice.application.payloads.response

import com.cyber.contentmanagerservice.domain.entities.Author
import java.time.LocalDateTime

data class AuthorResponse(
    val email: String,
    val nickname: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    constructor(author: Author) : this(
        email = author.email,
        nickname = author.nickname,
        createdAt = author.createdAt,
        updatedAt = author.updatedAt
    )
}
