package com.cyber.contentmanagerservice.domain.entities

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Content(
    val _id: ObjectId? = null,
    val title: String,
    val subtitle: String?,
    val description: String,
    val datetime: LocalDateTime? = LocalDateTime.now(),
    val url: String,
    val type: Type,
    val authorEmail: String
) {
    constructor(newContent: ContentRequest) : this(
        title = newContent.title,
        subtitle = newContent.subtitle,
        description = newContent.description,
        datetime = newContent.datetime,
        url = newContent.url,
        type = newContent.type,
        authorEmail = newContent.authorEmail
    )
}

enum class Type {
    REPOSITORY, ARTICLE
}
