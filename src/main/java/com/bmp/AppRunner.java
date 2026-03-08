package com.bmp;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class AppRunner {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8085);

        Context ctx = tomcat.addWebapp("/ERP", new File(webappDirLocation).getAbsolutePath());
        ctx.setParentClassLoader(AppRunner.class.getClassLoader());

        System.out.println("ServletContext loaded from: "
                + javax.servlet.ServletContext.class.getProtectionDomain().getCodeSource().getLocation());

        System.out.println("Starting Tomcat on port 8085...");

        tomcat.start();
        System.out.println("Tomcat started. Access at http://localhost:8085/ERP/");

        // Keep it alive with a loop to see if it stays running
        while (true) {
            Thread.sleep(5000);
            System.out.println("Tomcat is still running...");
        }
    }
}
