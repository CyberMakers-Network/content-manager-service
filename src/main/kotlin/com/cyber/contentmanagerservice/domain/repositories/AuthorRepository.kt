package com.cyber.contentmanagerservice.domain.repositories

import com.cyber.contentmanagerservice.domain.entities.Author
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface AuthorRepository : MongoRepository<Author, UUID> {
    fun findAuthorByEmail(email: String): Optional<Author>
}
