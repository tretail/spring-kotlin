package io.tretail.blog

import io.tretail.blog.entities.Article
import io.tretail.blog.entities.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import toSlug

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository) {

    @Test
    fun `When findBySlug then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val title = "Spring Framework 5.0 goes GA"
        val article = Article(title, "Dear Spring community ...", "Lorem ipsum", juergen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findBySlug(title.toSlug())
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val user = userRepository.findByLogin(juergen.login)
        assertThat(user).isEqualTo(juergen)
    }
}