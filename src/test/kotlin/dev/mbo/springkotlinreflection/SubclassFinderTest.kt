package dev.mbo.springkotlinreflection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubclassFinderTest {

    @Test
    fun findAllSubclassesOf() {
        val result = SubclassFinder.findAllSubclassesOf(
            basePackage = Base::class.java.packageName,
            assignableType = Base::class.java
        )
        assertThat(result).hasSize(2)
    }
}