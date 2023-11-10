package com.example.findme

data class MyData(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<Result>
)