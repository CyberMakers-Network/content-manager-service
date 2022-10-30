package com.cyber.contentmanagerservice.domain.entities

import java.time.LocalDateTime

data class Content(
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
