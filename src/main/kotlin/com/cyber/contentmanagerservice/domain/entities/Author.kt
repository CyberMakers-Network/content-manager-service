package com.cyber.contentmanagerservice.domain.entities

import org.bson.types.ObjectId

data class Author(
    val _id: ObjectId? = null,
    val name: String,
    val surname: String,
    val email: String,
    val nickname: String
)
