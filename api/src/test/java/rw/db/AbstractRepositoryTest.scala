package rw.db

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import rw.entity.SequenceId

object AbstractRepositoryTest {
  private val LOG: Logger = LoggerFactory.getLogger(classOf[AbstractRepositoryTest[_ <: SequenceId]])
}
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringBootTest
abstract class AbstractRepositoryTest[T <: SequenceId] {
  @Test def shouldDoCrud() {
    // Create
    var entity: T = instance
    getRepository.saveAndFlush(entity)
    AbstractRepositoryTest.LOG.debug("Test entity {} saved with id {}", entity.getClass, entity.getId)
    // Read
    entity = getRepository.findOne(entity.getId)
    // Update
    update(entity)
    getRepository.saveAndFlush(entity)
    // Delete
    getRepository.delete(entity.getId)
    AbstractRepositoryTest.LOG.debug("Deleted test entity {} with id {}", entity.getClass, entity.getId)
  }

  protected def instance: T

  protected def getRepository: JpaRepository[T, Integer]

  protected def update(instance: T)
}