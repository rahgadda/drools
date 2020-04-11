package org.onestart.com;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("Creating kieBase");
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();

        LOG.info("Creating kSession");
        KieSession kSession = kc.newKieSession("hello-world-rules");

        LOG.info("Creating Fact - isGreetingDone = True");
        HelloWorld helloWorld = new HelloWorld("Rahul");
        FactHandle factHandel = kSession.insert(helloWorld);

        LOG.info("Running RuleEngine");
        kSession.fireAllRules();

        LOG.info("Display Updated Message");
        System.out.println(helloWorld.getMessage());

        LOG.info("Update Fact - isGreetingDone = False");
        kSession.delete(factHandel);
        helloWorld.setIsGreetingDone(false);
        kSession.insert(helloWorld);

        LOG.info("Running RuleEngine");
        kSession.fireAllRules();
        
        LOG.info("Display Updated Message");
        System.out.println(helloWorld.getMessage());
        
        kSession.dispose();
        LOG.info("Closing kSession");
    }
}
