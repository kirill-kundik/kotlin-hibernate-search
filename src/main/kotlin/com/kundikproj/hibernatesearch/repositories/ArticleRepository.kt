package com.kundikproj.hibernatesearch.repositories

import com.kundikproj.hibernatesearch.models.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {
}
