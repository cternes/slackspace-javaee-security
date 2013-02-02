package de.slackspace.tutorials.glassfishjdbcrealm.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.slackspace.tutorials.glassfishjdbcrealm.service.UserService;

@Named
@RequestScoped
public class Index {
    
    @Inject
    UserService service;
    
    private String username;
    private String password;
    
    public void save() {
        service.createUserAndGroup(username, password, "users");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User created"));
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
