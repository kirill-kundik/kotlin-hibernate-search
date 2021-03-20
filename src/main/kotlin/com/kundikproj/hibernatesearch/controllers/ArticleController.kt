package com.kundikproj.hibernatesearch.controllers

import com.kundikproj.hibernatesearch.models.Article
import com.kundikproj.hibernatesearch.repositories.ArticleRepository
import com.kundikproj.hibernatesearch.services.ArticleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/articles")
class ArticleController(val articleRepository: ArticleRepository, private val articleService: ArticleService) {

    @GetMapping
    fun getArticles(): List<Article> = articleRepository.findAll()

    @GetMapping("/search")
    fun search(@RequestParam("q") text: String): List<Article> {
        return articleService.search(text)
    }

    @RequestMapping(path = [("/{articleId}")], method = [(RequestMethod.GET)])
    fun getArticle(@PathVariable("articleId") articleId: Long): Optional<Article>? {
        return articleRepository.findById(articleId)
    }

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        articleRepository.save(article)
        return article
    }


/*    @RequestMapping(path = [("/{articleId}")], method = [RequestMethod.PUT, RequestMethod.PATCH])
    @ResponseStatus(HttpStatus.OK)
    fun updateArticle(@PathVariable("articleId") articleId: Long, ) {
        articleRepository.save(article)
    }*/

    @RequestMapping(path = [("/{articleId}")], method = [(RequestMethod.DELETE)])
    fun deleteArticle(@PathVariable("articleId") articleId: Long) {
        articleRepository.deleteById(articleId)
    }

}
