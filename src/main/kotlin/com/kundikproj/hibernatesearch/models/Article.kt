package com.kundikproj.hibernatesearch.models

import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import javax.persistence.*

@Entity
@Table(name = "articles")
@Indexed
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "title", nullable = false)
        @Field
        var title: String? = null,

        @Column(name = "description", nullable = true)
        @Field
        var description: String? = null,

        @Column(name = "content", nullable = false)
        @Field
        var content: String? = null,

        @Column(name = "author_name", nullable = false)
        @Field
        var authorName: String? = null,
)
