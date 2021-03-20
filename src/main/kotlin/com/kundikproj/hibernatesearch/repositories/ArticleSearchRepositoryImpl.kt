package com.kundikproj.hibernatesearch.repositories

import com.kundikproj.hibernatesearch.models.Article
import org.hibernate.search.jpa.FullTextQuery
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
@Transactional
class ArticleSearchRepositoryImpl(@PersistenceContext val entityManager: EntityManager) {
    fun searchArticles(text: String): List<Article> {
        // get the full text entity manager
        val fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager)

        // create the query using Hibernate Search query DSL
        val queryBuilder = fullTextEntityManager.searchFactory
                .buildQueryBuilder().forEntity(Article::class.java).get()

        // a very basic query by keywords
        val query = queryBuilder
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(0)
                .onFields("content", "authorName", "title", "description")
                .matching(text)
                .createQuery()

        // wrap Lucene query in an Hibernate Query object
        val jpaQuery: FullTextQuery = fullTextEntityManager.createFullTextQuery(query, Article::class.java)

        // execute search and return results (sorted by relevance as default)

        return jpaQuery.resultList.map { result -> result as Article }.toList()
    }
}
