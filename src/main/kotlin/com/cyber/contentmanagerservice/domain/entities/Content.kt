package com.cyber.contentmanagerservice.domain.entities

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import java.time.LocalDateTime

data class Content(
    val title: String,
    val subtitle: String?,
    val description: String,
    val datetime: LocalDateTime? = LocalDateTime.now(),
    val url: String,
    val type: Type
) {
    constructor(newContent: ContentRequest) : this(
        title = newContent.title,
        subtitle = newContent.subtitle,
        description = newContent.description,
        datetime = newContent.datetime,
        url = newContent.url,
        type = newContent.type
    )
}

enum class Type {
    REPOSITORY, ARTICLE
}
