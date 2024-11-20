package com.mycompany.arrendapp;

import java.util.HashSet;
import java.util.Set;

import ControlAPI.DBUserCliente_Controller;
import ControlAPI.DBUserUsers_Controller;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilter.class);
        classes.add(DBUserCliente_Controller.class);
        classes.add(DBUserUsers_Controller.class);
        return classes;
    }
}
