package rw.test;

import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.yml.old")
@EnableConfigurationProperties
@ComponentScan({"rw"})
@ContextConfiguration(initializers=ConfigFileApplicationContextInitializer.class)
public abstract class AbstractIntegrationTest {
}
