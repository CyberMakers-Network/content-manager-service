package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.domain.exceptions.AuthorAlreadyExistsException
import com.cyber.contentmanagerservice.domain.factories.AuthorFactory
import com.cyber.contentmanagerservice.domain.factories.AuthorRequestFactory
import com.cyber.contentmanagerservice.domain.repositories.AuthorRepository
import com.cyber.contentmanagerservice.domain.services.impl.AuthorServiceImpl
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class AuthorServiceTest {

    private val authorRepository = mockk<AuthorRepository>()

    private val service = AuthorServiceImpl(
        authorRepository = authorRepository
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun `it should be registered an author`() {
        val mockAuthorRequest = AuthorRequestFactory.sample()
        val mockAuthor = AuthorFactory.sample()

        every {
            authorRepository.findAuthorByEmail(any())
        } returns Optional.empty()

        every {
            authorRepository.save(any())
        } returns mockAuthor

        service.create(mockAuthorRequest)

        verify(exactly = 1) {
            authorRepository.findAuthorByEmail(any())
            authorRepository.save(any())
        }
    }

    @Test
    fun `it should throw author already exist exception`() {
        val mockAuthor = AuthorFactory.sample()
        val mockAuthorRequest = AuthorRequestFactory.sample()

        every {
            authorRepository.findAuthorByEmail(any())
        } returns Optional.of(mockAuthor)

        assertThrows<AuthorAlreadyExistsException> {
            service.create(mockAuthorRequest)
        }
    }
}
