package com.cyber.contentmanagerservice.application.web.controllers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.cyber.contentmanagerservice.domain.exceptions.ContentNotFoundException
import com.cyber.contentmanagerservice.domain.factories.ContentFactory
import com.cyber.contentmanagerservice.domain.factories.ContentRequestFactory
import com.cyber.contentmanagerservice.domain.services.ContentService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus

class ContentControllerTest {

    private val contentService = mockk<ContentService>()

    private val controller = ContentController(
        contentService = contentService
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun `it should be register a new content`() {
        val mockContentRequest = ContentRequestFactory.sample()
        val mockContent = ContentFactory.sample()

        every {
            contentService.register(any())
        } returns mockContent

        val result = controller.register(mockContentRequest)

        verify(exactly = 1) {
            contentService.register(any())
        }

        assertThat(result.statusCode).isEqualTo(HttpStatus.CREATED)

        assertThat(result.body!!.title).isEqualTo(mockContent.title)
        assertThat(result.body!!.subtitle).isEqualTo(mockContent.subtitle)
        assertThat(result.body!!.description).isEqualTo(mockContent.description)
        assertThat(result.body!!.dateTime).isEqualTo(mockContent.datetime)
        assertThat(result.body!!.authorEmail).isEqualTo(mockContent.authorEmail)
        assertThat(result.body!!.type).isEqualTo(mockContent.type)
        assertThat(result.body!!.url).isEqualTo(mockContent.url)
    }

    @Test
    fun `it should be return a content by title`() {
        val mockContent = ContentFactory.sample()

        every {
            contentService.findByTitle(any())
        } returns mockContent

        val result = controller.getContentByTitle("test")

        verify(exactly = 1) {
            contentService.findByTitle(any())
        }

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)

        assertThat(result.body!!.title).isEqualTo(mockContent.title)
        assertThat(result.body!!.subtitle).isEqualTo(mockContent.subtitle)
        assertThat(result.body!!.description).isEqualTo(mockContent.description)
        assertThat(result.body!!.dateTime).isEqualTo(mockContent.datetime)
        assertThat(result.body!!.authorEmail).isEqualTo(mockContent.authorEmail)
        assertThat(result.body!!.type).isEqualTo(mockContent.type)
        assertThat(result.body!!.url).isEqualTo(mockContent.url)
    }

    @Test
    fun `it should throw content not found exception`() {
        every {
            contentService.findByTitle(any())
        } throws ContentNotFoundException()

        assertThrows<ContentNotFoundException> {
            controller.getContentByTitle("test")
        }
    }
}
