package com.cyber.contentmanagerservice.domain.entities

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Author(
    val _id: ObjectId? = null,
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now()
) {
    constructor(authorRequest: AuthorRequest) : this(
        name = authorRequest.name,
        surname = authorRequest.surname,
        email = authorRequest.email,
        nickname = authorRequest.nickname
    )
}
