package com.example.spacexlaunches.model

data class Launch(
    val id: String? = null,
    val name: String? = null,
    val details: String? = null,
    val links: Links? = null
) {
    data class Links(
        val patch: Patch? = null
    )
    data class Patch(
        val small: String? = null
    )
}
