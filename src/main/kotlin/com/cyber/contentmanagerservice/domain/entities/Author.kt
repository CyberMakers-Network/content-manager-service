package com.cyber.contentmanagerservice.domain.entities

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest
import org.bson.types.ObjectId

data class Author(
    val _id: ObjectId? = null,
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String
) {
    constructor(authorRequest: AuthorRequest) : this(
        name = authorRequest.name,
        surname = authorRequest.surname,
        email = authorRequest.email,
        nickname = authorRequest.nickname
    )
}
