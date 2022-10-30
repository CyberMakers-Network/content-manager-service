package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.domain.entities.Content
import org.bson.types.ObjectId

interface ContentService {
    fun getById(id: ObjectId): Content?
}