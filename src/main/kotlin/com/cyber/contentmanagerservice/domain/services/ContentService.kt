package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import com.cyber.contentmanagerservice.domain.entities.Content

interface ContentService {
    fun register(newContent: ContentRequest): Content
    fun findByTitle(title: String): Content?
}
