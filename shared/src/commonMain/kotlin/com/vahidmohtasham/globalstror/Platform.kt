package com.vahidmohtasham.globalstror

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform