package com.cyber.contentmanagerservice.domain.exceptions

import org.springframework.http.HttpStatus

class ContentHasBeenRegisteredException(
    reason: String = "Not possible, content already registered!"
) : ApiException(reason = reason, httpStatus = HttpStatus.BAD_REQUEST)
