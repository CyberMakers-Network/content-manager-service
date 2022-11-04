package com.cyber.contentmanagerservice.application.web.controllers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.cyber.contentmanagerservice.domain.factories.AuthorFactory
import com.cyber.contentmanagerservice.domain.factories.AuthorRequestFactory
import com.cyber.contentmanagerservice.domain.services.AuthorService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class AuthorControllerTest {

    private val authorService = mockk<AuthorService>()

    private val controller = AuthorController(
        authorService = authorService
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun `it should be return created author`() {
        val mockAuthor = AuthorFactory.sample()
        val mockAuthorRequest = AuthorRequestFactory.sample()

        every {
            authorService.create(any())
        } returns mockAuthor

        val result = controller.create(mockAuthorRequest)

        assertThat(result.statusCode).isEqualTo(HttpStatus.CREATED)
        assertThat(result.body!!.email).isEqualTo(mockAuthor.email)
        assertThat(result.body!!.nickname).isEqualTo(mockAuthor.nickname)
        assertThat(result.body!!.createdAt).isEqualTo(mockAuthor.createdAt)
        assertThat(result.body!!.updatedAt).isEqualTo(mockAuthor.updatedAt)
    }
}