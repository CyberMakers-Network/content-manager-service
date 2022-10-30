package com.cyber.contentmanagerservice.application.payloads.request

import com.cyber.contentmanagerservice.domain.entities.Type
import java.time.LocalDateTime

data class ContentRequest(
    val title: String,
    val subtitle: String?,
    val description: String,
    val datetime: LocalDateTime? = LocalDateTime.now(),
    val url: String,
    val type: Type
)
