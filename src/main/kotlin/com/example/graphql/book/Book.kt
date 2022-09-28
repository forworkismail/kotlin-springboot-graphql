package com.example.graphql.book

import com.example.graphql.author.Author
import com.example.graphql.rating.Rating
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "books")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var title: String = ""

    var pages: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    var author: Author = Author()

    var rating: Rating = Rating.ONE_STAR
}