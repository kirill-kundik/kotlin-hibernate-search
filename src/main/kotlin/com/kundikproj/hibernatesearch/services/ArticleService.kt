package com.kundikproj.hibernatesearch.services

import com.kundikproj.hibernatesearch.models.Article
import com.kundikproj.hibernatesearch.repositories.ArticleRepository
import com.kundikproj.hibernatesearch.repositories.ArticleSearchRepositoryImpl
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ArticleService(private val articleRepository: ArticleRepository, private val articleSearchRepositoryImpl: ArticleSearchRepositoryImpl) {
    fun findAll(): List<Article> {
        return articleRepository.findAll()
    }

    fun search(text: String): List<Article> {
        return articleSearchRepositoryImpl.searchArticles(text)
    }

    fun saveUser(article: Article): Article {
        return articleRepository.save(article)
    }
}