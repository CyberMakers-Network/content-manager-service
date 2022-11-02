package com.cyber.contentmanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class AuthorNotFoundException(
    reason: String = "Author's not found!"
) : ApiException(reason = reason, httpStatus = HttpStatus.BAD_REQUEST)
