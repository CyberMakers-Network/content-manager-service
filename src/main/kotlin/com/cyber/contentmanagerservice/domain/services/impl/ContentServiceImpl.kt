package com.cyber.contentmanagerservice.domain.services.impl

import com.cyber.contentmanagerservice.domain.entities.Content
import com.cyber.contentmanagerservice.domain.exceptions.ContentNotFoundException
import com.cyber.contentmanagerservice.domain.repositories.ContentRepository
import com.cyber.contentmanagerservice.domain.services.ContentService
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ContentServiceImpl(
    private val contentRepository: ContentRepository
) : ContentService {

    override fun getById(id: ObjectId): Content? {
        logger.info("Finding content with id=$id")
        return contentRepository.findById(id).orElseThrow { ContentNotFoundException() }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(ContentService::class.java)
    }
}
