package com.cyber.contentmanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class AuthorAlreadyExistsException(
    reason: String = "Author already exists!"
) : ApiException(reason = reason, httpStatus = HttpStatus.BAD_REQUEST)
