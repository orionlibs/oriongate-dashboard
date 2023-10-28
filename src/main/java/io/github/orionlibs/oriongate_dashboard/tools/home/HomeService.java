package io.github.orionlibs.oriongate_dashboard.tools.home;

import javafx.scene.web.WebEngine;
import lombok.AllArgsConstructor;

//Java class that can be accessed from JavaScript
@AllArgsConstructor
public class HomeService
{
    private WebEngine webEngine;


    public void myJavaMethod1()
    {
        System.out.println("Java method called!");
        webEngine.executeScript("myFunction2(\"value 4\")");
    }
    /*public int myJavaMethod1(String message)
    {
        System.out.println("Java method called! " + message);
        // Call the JavaScript function
        //webEngine.executeScript("myFunction2()");
        webEngine.executeScript("myFunction3(\"value 4\")");
        return 64;
    }*/
}
