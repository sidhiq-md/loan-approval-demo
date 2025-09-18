package com.example;

import com.example.model.loanApplication;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {
    public static void main(String[] args) {
        loanApplication app = new loanApplication("John", 30, 25000, 750);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("ksession-rules");

        ksession.insert(app);
        ksession.fireAllRules();
        ksession.dispose();

        System.out.println("Loan Application Result: " + app.getStatus());
    }
}
