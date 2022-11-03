package com.cyber.contentmanagerservice.domain.factories

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest

object AuthorRequestFactory {
    fun sample() = AuthorRequest(
        name = "dummy",
        surname = "dummyzinho",
        email = "dummy@email.com",
        nickname = "ImDummy"
    )
}
