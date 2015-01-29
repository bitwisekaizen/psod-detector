package com.thegrayfiles;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
// See http://stackoverflow.com/questions/25537436/integration-testing-a-spring-boot-web-app-with-testng
@TestExecutionListeners(inheritListeners = false, listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class })
@Test
public class PsodDetectorTest extends AbstractTestNGSpringContextTests {

    public void canDetectPsodOnVm() {
        String detectedText = getPsodTextForVm("esxi-test-vm");

        Assert.assertEquals(detectedText, "Hello, PSOD.");
    }

    private String getPsodTextForVm(String vm) {
        RestTemplate template = new RestTemplate();
        Psod psod = template.getForEntity("http://localhost:8080/psod?vm=" + vm, Psod.class).getBody();
        return psod.getText();
    }
}
