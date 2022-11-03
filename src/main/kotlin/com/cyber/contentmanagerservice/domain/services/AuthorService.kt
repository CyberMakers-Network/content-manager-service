package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest
import com.cyber.contentmanagerservice.domain.entities.Author

interface AuthorService {
    fun create(authorRequest: AuthorRequest): Author
}
