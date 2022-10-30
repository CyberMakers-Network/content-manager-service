package com.cyber.contentmanagerservice.application.web.controllers

import com.cyber.contentmanagerservice.application.payloads.response.ContentResponse
import com.cyber.contentmanagerservice.domain.services.ContentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/content")
class ContentController(
    private val contentService: ContentService
) {

    @GetMapping("/{title}")
    fun getContentByTitle(@PathVariable title: String): ResponseEntity<ContentResponse> {
        return ResponseEntity.ok(
            contentService.findByTitle(title)?.let {
                ContentResponse(
                    it
                )
            }
        )
    }
}
