package com.cyber.contentmanagerservice.application.web.controllers

import com.cyber.contentmanagerservice.domain.services.ContentService
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

class ContentControllerTest {

    private val contentService = mockk<ContentService>()

    private val controller = ContentController(
        contentService = contentService
    )

    @BeforeEach
    fun init() {
        clearAllMocks()
    }
}
