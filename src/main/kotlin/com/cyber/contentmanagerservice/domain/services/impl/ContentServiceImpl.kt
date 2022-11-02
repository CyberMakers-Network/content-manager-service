package com.cyber.contentmanagerservice.domain.services.impl

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import com.cyber.contentmanagerservice.domain.entities.Content
import com.cyber.contentmanagerservice.domain.exceptions.AuthorNotFoundException
import com.cyber.contentmanagerservice.domain.exceptions.ContentHasBeenRegisteredException
import com.cyber.contentmanagerservice.domain.exceptions.ContentNotFoundException
import com.cyber.contentmanagerservice.domain.repositories.AuthorRepository
import com.cyber.contentmanagerservice.domain.repositories.ContentRepository
import com.cyber.contentmanagerservice.domain.services.ContentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ContentServiceImpl(
    private val contentRepository: ContentRepository,
    private val authorRepository: AuthorRepository
) : ContentService {
    override fun register(newContent: ContentRequest): Content {
        contentRepository.findByTitle(newContent.title).ifPresent {
            logger.error("Content title has been registered")
            throw ContentHasBeenRegisteredException()
        }

        return authorRepository.findAuthorByEmail(newContent.authorEmail).orElseThrow { AuthorNotFoundException() }.let {
            contentRepository.save(
                Content(
                    newContent
                )
            ).also { logger.info("New content title=${it.title} registered!") }
        }
    }

    override fun findByTitle(title: String): Content? {
        logger.info("Finding content with title=$title")
        return contentRepository.findByTitle(title).orElseThrow { ContentNotFoundException() }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(ContentService::class.java)
    }
}
