package dev.jhseo.hasher

import java.nio.charset.Charset

fun String.hash(method: HasherMethod, charset: Charset = Charsets.UTF_8) : String {
    return Hasher.hash(this, method, charset)
}