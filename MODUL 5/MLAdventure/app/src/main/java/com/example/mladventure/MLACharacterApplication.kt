package com.example.mladventure

import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import kotlinx.serialization.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import okhttp3.RequestBody.Companion.toRequestBody

class JsonConverterFactory(
    private val json: Json,
    private val contentType: MediaType
) : Converter.Factory() {

    companion object {
        fun create(
            json: Json = Json { ignoreUnknownKeys = true },
            contentType: MediaType = "application/json".toMediaType()
        ): JsonConverterFactory = JsonConverterFactory(json, contentType)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val serializer = json.serializersModule.serializer(type)
        return Converter { body ->
            json.decodeFromString(serializer, body.string())
        }
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody> {
        val serializer = json.serializersModule.serializer(type)
        return Converter<Any, RequestBody> { value ->
            val content = json.encodeToString(serializer, value)
            content.toRequestBody(contentType)
        }
    }
}
