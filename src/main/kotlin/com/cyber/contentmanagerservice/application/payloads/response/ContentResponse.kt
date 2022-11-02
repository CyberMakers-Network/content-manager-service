package com.cyber.contentmanagerservice.application.payloads.response

import com.cyber.contentmanagerservice.domain.entities.Content
import com.cyber.contentmanagerservice.domain.entities.Type
import java.time.LocalDateTime

data class ContentResponse(
    val title: String,
    val subtitle: String?,
    val description: String,
    val dateTime: LocalDateTime?,
    val url: String,
    val type: Type,
    val authorEmail: String
) {
    constructor(content: Content) : this(
        title = content.title,
        subtitle = content.subtitle,
        description = content.description,
        dateTime = content.datetime,
        url = content.url,
        type = content.type,
        authorEmail = content.authorEmail
    )
}
