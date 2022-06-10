package com.gaur.data.model

data class MatchDTO(
    val meta: MetaDTO,
    val notifications: List<NotificationDTO>,
    val response: ResponseDTO
)