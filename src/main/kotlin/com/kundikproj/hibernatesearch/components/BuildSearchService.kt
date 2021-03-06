package com.kundikproj.hibernatesearch.components

import org.hibernate.search.jpa.Search
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Component
@Transactional
class BuildSearchService(
        @PersistenceContext val entityManager: EntityManager)
    : ApplicationListener<ApplicationReadyEvent> {

    override fun onApplicationEvent(p0: ApplicationReadyEvent) {
        try {
            val fullTextEntityManager = Search.getFullTextEntityManager(entityManager)
            fullTextEntityManager.createIndexer().startAndWait()
        } catch (e: InterruptedException) {
            println("An error occurred trying to build the search index: $e")
        }
    }
}