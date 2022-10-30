package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.domain.entities.Content

interface ContentService {
    fun findByTitle(title: String): Content?
}
