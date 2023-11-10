package com.example.findme

data class TitleType(
    val __typename: String,
    val canHaveEpisodes: Boolean,
    val categories: List<Category>,
    val id: String,
    val isEpisode: Boolean,
    val isSeries: Boolean,
    val text: String
)