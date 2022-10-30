package com.cyber.contentmanagerservice.domain.repositories

import com.cyber.contentmanagerservice.domain.entities.Content
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface ContentRepository : MongoRepository<Content, UUID> {
    fun findByTitle(title: String): Optional<Content>
}
