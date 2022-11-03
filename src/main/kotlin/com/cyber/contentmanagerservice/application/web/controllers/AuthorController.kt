package com.cyber.contentmanagerservice.application.web.controllers

import com.cyber.contentmanagerservice.application.payloads.request.AuthorRequest
import com.cyber.contentmanagerservice.application.payloads.response.AuthorResponse
import com.cyber.contentmanagerservice.domain.services.AuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorController(
    private val authorService: AuthorService
) {

    @PostMapping
    fun create(@RequestBody authorRequest: AuthorRequest): ResponseEntity<AuthorResponse> {
        return authorService.create(authorRequest).let {
            ResponseEntity(AuthorResponse(it), HttpStatus.CREATED)
        }
    }
}
