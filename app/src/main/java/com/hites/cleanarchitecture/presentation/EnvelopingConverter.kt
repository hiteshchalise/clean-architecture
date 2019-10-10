package com.hites.cleanarchitecture.presentation

import com.google.gson.reflect.TypeToken
import com.hites.cleanarchitecture.EnvelopeMovie
import java.lang.reflect.Type

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

class EnvelopingConverter : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<Annotation>?,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val envelopeType = TypeToken.getParameterized(EnvelopeMovie::class.java, type!!).type
        val delegate =
            retrofit.nextResponseBodyConverter<EnvelopeMovie<*>>(this, envelopeType, annotations!!)
        return Converter<ResponseBody, Any> { value ->
            val envelopeMovie = delegate.convert(value)
            envelopeMovie!!.results
        }
    }
}
