package dev.jhseo.hasher

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class HasherTest : ShouldSpec({
    should("return proper MD2 hash value") {
        Hasher.hash("Hasher", HasherMethod.MD2).toLowerCase() shouldBe "c4c48e7da7036a2e295ab1280ba247aa" //https://emn178.github.io/online-tools/md2.html
    }

    should("return proper MD5 hash value") {
        Hasher.hash("Hasher", HasherMethod.MD5).toLowerCase() shouldBe "c400d10350540028bf74eafd62280560" //https://emn178.github.io/online-tools/md5.html
    }

    should("return proper SHA1 hash value") {
        Hasher.hash("Hasher", HasherMethod.SHA1).toLowerCase() shouldBe "fc0f48d98ae0d2092a247d5cee9ccdb867d1d001" //https://emn178.github.io/online-tools/sha1.html
    }

    should("return proper SHA256 hash value") {
        Hasher.hash("Hasher", HasherMethod.SHA256).toLowerCase() shouldBe "75c33b0ef306257ae8759fb1750a74d748ba37913e90803edf95f3b82303ef3d" //https://emn178.github.io/online-tools/sha256.html
    }

    should("return proper SHA384 hash value") {
        Hasher.hash("Hasher", HasherMethod.SHA384).toLowerCase() shouldBe "783bc92b0c8d0193f257b208275924c3138b334400e32256cd406c7c15385780a9b29ce76f254b010fce6ef440d34583" //https://emn178.github.io/online-tools/sha384.html
    }

    should("return proper SHA512 hash value") {
        Hasher.hash("Hasher", HasherMethod.SHA512).toLowerCase() shouldBe "e42f0a813dc76e9e1d680a56c59eabecd28cab7c48fd8c8eea053f111df710fd7bdc053345f0d343ffe978b4e9f2dc601576f26a17ebcf2ece7d63a06864b8c4" //https://emn178.github.io/online-tools/sha512.html
    }
})