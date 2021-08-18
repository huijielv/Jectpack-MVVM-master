package com.mvvm.lib.anchors.tast

interface TaskCreator {
    fun createTask(taskName: String): Task
}

private typealias CreateTask = (taskName: String) -> Task

class TaskCreatorBuilder {

    lateinit var createTask: CreateTask

    fun createTask(createTask: CreateTask) {
        this.createTask = createTask
    }
}