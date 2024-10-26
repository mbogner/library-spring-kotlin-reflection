package dev.mbo.springkotlinreflection

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AssignableTypeFilter

object SubclassFinder {

    fun findAllSubclassesOf(
        basePackage: String,
        assignableType: Class<*>
    ): Set<Class<*>> {
        val provider = ClassPathScanningCandidateComponentProvider(false)
        provider.addIncludeFilter(AssignableTypeFilter(assignableType))
        return provider.findCandidateComponents(basePackage)
            .map { Class.forName(it.beanClassName) }
            .toSet()
    }

}