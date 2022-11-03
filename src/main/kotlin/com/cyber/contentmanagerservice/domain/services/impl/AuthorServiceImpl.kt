package com.cyber.contentmanagerservice.domain.services.impl

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest
import com.cyber.contentmanagerservice.domain.entities.Author
import com.cyber.contentmanagerservice.domain.exceptions.AuthorAlreadyExistsException
import com.cyber.contentmanagerservice.domain.repositories.AuthorRepository
import com.cyber.contentmanagerservice.domain.services.AuthorService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {

    override fun create(authorRequest: AuthorRequest): Author {
        authorRepository.findAuthorByEmail(authorRequest.email).ifPresent {
            logger.error("E-mail to author=${it.name} already registered!")
            throw AuthorAlreadyExistsException()
        }

        return authorRepository.save(
            Author(
                authorRequest
            )
        ).also {
            logger.info("Author=${it.name} is registered with success!!!")
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(AuthorService::class.java)
    }
}
