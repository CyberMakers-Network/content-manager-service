package com.cyber.contentmanagerservice.domain.factories

import com.cyber.contentmanagerservice.application.payloads.response.AuthorResponse
import java.time.LocalDateTime

object AuthorResponseFactory {
    fun sample() = AuthorResponse(
        email = "teste@email.com",
        nickname = "dummy",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}
