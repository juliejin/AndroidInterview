package com.example.androidinterview.data.model

data class OperationResult<T> internal constructor(val status: Status, val data: T?, val errorMessage: String?){
    enum class Status {
        SUCCESS,
        ERROR
    }

    fun isErrorState(): Boolean {
        return status == Status.ERROR
    }

    companion object {
        fun <T> success(data: T?): OperationResult<T> {
            return OperationResult(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, errorMessage: String?): OperationResult<T> {
            return OperationResult(Status.ERROR, data, errorMessage)
        }
    }
}