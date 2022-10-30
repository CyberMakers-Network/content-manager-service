package com.cyber.contentmanagerservice.domain.services.impl

import com.cyber.contentmanagerservice.domain.entities.Content
import com.cyber.contentmanagerservice.domain.exceptions.ContentNotFoundException
import com.cyber.contentmanagerservice.domain.repositories.ContentRepository
import com.cyber.contentmanagerservice.domain.services.ContentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ContentServiceImpl(
    private val contentRepository: ContentRepository
) : ContentService {

    override fun findByTitle(title: String): Content? {
        logger.info("Finding content with title=$title")
        return contentRepository.findByTitle(title).orElseThrow { ContentNotFoundException() }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(ContentService::class.java)
    }
}
