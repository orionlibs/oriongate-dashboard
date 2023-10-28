package io.github.orionlibs.oriongate_dashboard.tools.home;

//Java class that can be accessed from JavaScript
public class HomeService
{
    public String myJavaMethod1(String message)
    {
        System.out.println("Java method called! " + message);
        return "received: " + message;
    }
}
