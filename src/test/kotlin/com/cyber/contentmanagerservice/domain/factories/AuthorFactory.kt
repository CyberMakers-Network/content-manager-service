package com.cyber.contentmanagerservice.domain.factories

import com.cyber.contentmanagerservice.domain.entities.Author

object AuthorFactory {
    fun sample() = Author(
        name = "teste",
        surname = "teste",
        nickname = "teste",
        email = "teste@teste.com"
    )
}