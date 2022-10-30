package com.cyber.contentmanagerservice.domain.entities

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Content(
    @Id
    val _id: ObjectId,

    val title: String,
    val subtitle: String?,
    val description: String,
    val datetime: LocalDateTime? = LocalDateTime.now(),
    val url: String,
    val type: Type
)

enum class Type {
    REPOSITORY, ARTICLE
}
