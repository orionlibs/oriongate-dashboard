package io.github.orionlibs.oriongate_dashboard.tools.home;

import io.github.orionlibs.oriongate_dashboard.Page;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HomePage extends Page
{
    public HomePage() throws IOException
    {
        //super("/configuration/pages/home/home.html", null);
        super();
        setPagePathToLoad("/configuration/pages/home/home.html");
        HomePagePanel homePage = new HomePagePanel();
        homePage.setLayout(new BorderLayout());
        homePage.add(javafxPanel, BorderLayout.CENTER);
        initSwingComponents();
        addPanel(homePage);
        loadJavaFXScene();
    }


    public void loadHomePage() throws IOException
    {
        /*HomePagePanel homePage = new HomePagePanel();
        homePage.setLayout(new BorderLayout());
        //homePage.add(javafxPanel, BorderLayout.CENTER);
        addPanel(homePage);
        revalidate();
        repaint();*/
        setNewScene("/configuration/pages/home/home.html");
    }


    public void loadHome2Page() throws IOException
    {
        //Home2PagePanel home2Page = new Home2PagePanel();
        //home2Page.setLayout(new BorderLayout());
        //home2Page.add(javafxPanel, BorderLayout.CENTER);
        //getComponent(0).paint(home2Page.getGraphics());
        //getComponent(0).invalidate();
        //getComponent(0).setEnabled(false);
        //getComponent(0).update(home2Page.getGraphics());
        //getComponent(0).revalidate();
        //getComponent(0).repaint();
        //addPanel(home2Page);
        //revalidate();
        //repaint();
        setNewScene("/configuration/pages/home/home2.html");
    }
}
