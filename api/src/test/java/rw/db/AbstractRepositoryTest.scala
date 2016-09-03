package rw.db

import com.typesafe.scalalogging.LazyLogging
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import rw.entity.SequenceId


@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringBootTest
abstract class AbstractRepositoryTest[T <: SequenceId] extends LazyLogging {
  @Test def shouldDoCrud() {
    // Create
    var entity: T = instance
    getRepository.saveAndFlush(entity)
    logger.debug(s"Test entity $entity.getClass saved with id $entity.id")
    // Read
    entity = getRepository.findOne(entity.getId)
    // Update
    update(entity)
    getRepository.saveAndFlush(entity)
    // Delete
    getRepository.delete(entity.getId)
    logger.debug(s"Deleted test entity $entity.getClass with id $entity.id")
  }

  protected def instance: T

  protected def getRepository: JpaRepository[T, Integer]

  protected def update(instance: T)
}