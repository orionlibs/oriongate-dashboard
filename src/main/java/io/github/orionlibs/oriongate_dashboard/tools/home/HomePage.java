package io.github.orionlibs.oriongate_dashboard.tools.home;

import io.github.orionlibs.oriongate_dashboard.Page;
import java.io.IOException;

public class HomePage extends Page
{
    public HomePage() throws IOException
    {
        super();
        setPagePathToLoad("/configuration/pages/home/home.html");
        /*HomePagePanel homePage = new HomePagePanel();
        homePage.setLayout(new BorderLayout());
        homePage.setBackground(Color.black);
        homePage.add(javafxPanel, BorderLayout.CENTER);*/
        initSwingComponents();
        loadJavaFXScene();
    }


    public void loadHomePage() throws IOException
    {
        //HomePagePanel homePage = new HomePagePanel();
        setNewScene("/configuration/pages/home/home.html");
    }


    public void loadHome2Page() throws IOException
    {
        //Home2PagePanel home2Page = new Home2PagePanel();
        setNewScene("/configuration/pages/home/home2.html");
    }
}
