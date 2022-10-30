package com.cyber.contentmanagerservice.application.web.controllers

import com.cyber.contentmanagerservice.application.payloads.request.ContentRequest
import com.cyber.contentmanagerservice.application.payloads.response.ContentResponse
import com.cyber.contentmanagerservice.domain.services.ContentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/content")
class ContentController(
    private val contentService: ContentService
) {

    @PostMapping
    fun register(@RequestBody newContent: ContentRequest): ResponseEntity<ContentResponse> {
        return contentService.register(newContent).let {
            ResponseEntity(ContentResponse(it), HttpStatus.CREATED)
        }
    }

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
