package dev.jhseo.hasher

import java.nio.charset.Charset

/**
 * Base class of the hasher library.
 *
 * @author jhseo1107
 * @since 1.0.0
 */
object Hasher {
    /**
     * Simple wrapper method to run [HasherMethod.algorithm]
     *
     * @param text Text to hash.
     * @param method An entity of [HasherMethod].
     * @param charset Charset of [text]. Default is [Charsets.UTF_8]
     * @return Result of hashing.
     * @author jhseo1107
     * @since 1.0.0
     */
    fun hash(text: String, method: HasherMethod, charset: Charset = Charsets.UTF_8): String {
        return method.algorithm(text, charset)
    }
}