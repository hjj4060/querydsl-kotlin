package study.querydsl_kotlin

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import study.querydsl_kotlin.entity.Hello
import study.querydsl_kotlin.entity.QHello

@SpringBootTest
@Transactional
class QuerydslKotlinApplicationTests(
) {
	@Autowired
	private lateinit var em: EntityManager

	@Test
	fun contextLoads() {
		val hello = Hello()
		em.persist(hello)

		val query = JPAQueryFactory(em)
		val qHello = QHello.hello

		val result = query.selectFrom(qHello).fetchOne()

		assertThat(result).isEqualTo(hello)
		assertThat(result!!.id).isEqualTo(hello.id)
	}
}