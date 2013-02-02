package de.slackspace.tutorials.glassfishjdbcrealm.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

import de.slackspace.tutorials.glassfishjdbcrealm.domain.Group;
import de.slackspace.tutorials.glassfishjdbcrealm.domain.User;

@Stateless
public class UserService {

    private MessageDigest md;
    
    @PersistenceContext
    EntityManager em;
    
    public void createUserAndGroup(String username, String password, String groupname) {
        User user = new User();
        user.setUsername(username);
        String encodedPassword = encodePassword(password);
        user.setPassword(encodedPassword);
        em.persist(user);
        
        Group group = new Group();
        group.setGroupname(groupname);
        group.setUsername(username);
        em.persist(group);
    }

    private String encodePassword(String password) {
        if(md == null) {
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return DatatypeConverter.printBase64Binary(digest).toString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
