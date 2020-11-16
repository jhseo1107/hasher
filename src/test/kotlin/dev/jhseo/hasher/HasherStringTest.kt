package dev.jhseo.hasher

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class HasherStringTest : ShouldSpec({
    should("return proper hashed value on String.hash()") {
        "Hasher".hash(HasherMethod.SHA256).toLowerCase() shouldBe "75c33b0ef306257ae8759fb1750a74d748ba37913e90803edf95f3b82303ef3d" //https://emn178.github.io/online-tools/sha256.html
    }
})