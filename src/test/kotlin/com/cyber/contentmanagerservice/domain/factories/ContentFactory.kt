package com.cyber.contentmanagerservice.domain.factories

import com.cyber.contentmanagerservice.domain.entities.Content
import com.cyber.contentmanagerservice.domain.entities.Type
import java.time.LocalDateTime

object ContentFactory {
    fun sample() = Content(
        title = "Title",
        subtitle = "Subtitle",
        description = "Description",
        datetime = LocalDateTime.now(),
        url = "teste.com",
        type = Type.ARTICLE
    )
}
