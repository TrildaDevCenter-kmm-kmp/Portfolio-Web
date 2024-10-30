package com.andreasgift.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform