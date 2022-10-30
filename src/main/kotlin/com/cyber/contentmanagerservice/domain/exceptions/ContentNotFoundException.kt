package com.cyber.contentmanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class ContentNotFoundException(
    reason: String = "Content not found or reference id not registered."
) : ApiException(httpStatus = HttpStatus.NOT_FOUND, reason = reason)
