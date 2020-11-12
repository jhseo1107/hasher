package dev.jhseo.hasher

import java.nio.charset.Charset
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * The hashing method wrapper class.
 *
 * @param algorithm Real function running the hashing progress.
 * @author jhseo1107
 * @since 1.0.0
 */
class HasherMethod (internal val algorithm: (String, Charset) -> String) {
    /**
     * Standard hashing methods brought to you by the Hasher library.
     *
     * @author jhseo1107
     * @since 1.0.0
     */
    companion object {
        /**
         * The classic hashing method of java.
         *
         * @param methodName The hashing algorithm name in classic java.
         * @return Belonging function to [methodName]
         * @author jhseo1107
         * @since 1.0.0
         */
        private fun defaultJvmHashMethod (methodName: String) : (String, Charset) -> String {
            return {content: String, charset: Charset -> DatatypeConverter.printHexBinary(MessageDigest.getInstance(methodName).digest(content.toByteArray(charset)))}
        }

        @JvmStatic
        val MD2 = HasherMethod(defaultJvmHashMethod("MD2"))

        @JvmStatic
        val MD5 = HasherMethod(defaultJvmHashMethod("MD5"))

        @JvmStatic
        val SHA1 = HasherMethod(defaultJvmHashMethod("SHA-1"))

        @JvmStatic
        val SHA256 = HasherMethod(defaultJvmHashMethod("SHA-256"))

        @JvmStatic
        val SHA384 = HasherMethod(defaultJvmHashMethod("SHA-384"))

        @JvmStatic
        val SHA512 = HasherMethod(defaultJvmHashMethod("SHA-512"))
    }
}