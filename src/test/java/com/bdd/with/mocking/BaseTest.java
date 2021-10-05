package com.bdd.with.mocking;

import com.bdd.with.mocking.BddWithMockingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author tanu_dua
 */
@SpringBootTest(classes = BddWithMockingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@DirtiesContext( classMode = DirtiesContext.ClassMode.AFTER_CLASS )
@CucumberContextConfiguration
public class BaseTest {
}

