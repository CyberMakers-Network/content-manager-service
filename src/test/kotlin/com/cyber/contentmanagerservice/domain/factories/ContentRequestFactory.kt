package com.cyber.contentmanagerservice.domain.factories

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import com.cyber.contentmanagerservice.domain.entities.Type
import java.time.LocalDateTime

object ContentRequestFactory {
    fun sample() = ContentRequest(
        title = "title",
        subtitle = "subtitle",
        description = "description",
        datetime = LocalDateTime.now(),
        url = "test.com",
        type = Type.ARTICLE
    )
}