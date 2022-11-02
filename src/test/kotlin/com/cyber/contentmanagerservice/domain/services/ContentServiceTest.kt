package com.cyber.contentmanagerservice.domain.services

import com.cyber.contentmanagerservice.domain.exceptions.ContentHasBeenRegisteredException
import com.cyber.contentmanagerservice.domain.exceptions.ContentNotFoundException
import com.cyber.contentmanagerservice.domain.factories.AuthorFactory
import com.cyber.contentmanagerservice.domain.factories.ContentFactory
import com.cyber.contentmanagerservice.domain.factories.ContentRequestFactory
import com.cyber.contentmanagerservice.domain.repositories.AuthorRepository
import com.cyber.contentmanagerservice.domain.repositories.ContentRepository
import com.cyber.contentmanagerservice.domain.services.impl.ContentServiceImpl
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ContentServiceTest {

    private val contentRepository = mockk<ContentRepository>()
    private val authorRepository = mockk<AuthorRepository>()

    private val service = ContentServiceImpl(
        contentRepository = contentRepository,
        authorRepository = authorRepository
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun `it should throw content title has been registered exception`() {
        val mockContent = ContentFactory.sample()
        val mockContentRequest = ContentRequestFactory.sample()

        every {
            contentRepository.findByTitle(any())
        } returns Optional.of(mockContent)

        assertThrows<ContentHasBeenRegisteredException> {
            service.register(mockContentRequest)
        }
    }

    @Test
    fun `it should be register a new content`() {
        val mockContent = ContentFactory.sample()
        val mockContentRequest = ContentRequestFactory.sample()
        val mockAuthor = AuthorFactory.sample()

        every {
            contentRepository.findByTitle(any())
        } returns Optional.empty()

        every {
            authorRepository.findAuthorByEmail(any())
        } returns Optional.of(mockAuthor)

        every {
            contentRepository.save(any())
        } returns mockContent

        service.register(mockContentRequest)

        verify(exactly = 1) {
            contentRepository.findByTitle(any())
            contentRepository.save(any())
            authorRepository.findAuthorByEmail(any())
        }
    }

    @Test
    fun `it should throw content not found exception`() {
        every {
            contentRepository.findByTitle(any())
        } returns Optional.empty()

        assertThrows<ContentNotFoundException> {
            service.findByTitle("test")
        }
    }

    @Test
    fun `it should be return a correspondent content register`() {
        val mockContent = ContentFactory.sample()

        every {
            contentRepository.findByTitle(any())
        } returns Optional.of(mockContent)

        service.findByTitle("test")

        verify(exactly = 1) {
            contentRepository.findByTitle(any())
        }
    }
}
