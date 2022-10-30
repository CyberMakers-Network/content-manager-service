package com.cyber.contentmanagerservice.domain.repositories

import com.cyber.contentmanagerservice.domain.entities.Content
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository : MongoRepository<Content, ObjectId>
