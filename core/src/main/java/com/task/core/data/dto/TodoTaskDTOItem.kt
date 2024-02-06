package com.task.core.data.dto

import com.task.core.domain.model.TodoTaskList


data class UniversityDTOItem(
    val name: String? = "",
    val code: String? = "",
    val country: String? = "",
){
    fun toUniversityList(): TodoTaskList {
        return TodoTaskList(
            name = name,
            code = code,
            country = country
        )
    }
}