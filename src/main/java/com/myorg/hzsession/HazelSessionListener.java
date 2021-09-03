package com.myorg.hzsession;

import com.hazelcast.web.HazelcastHttpSession;
import com.hazelcast.web.SessionListener;
import com.hazelcast.web.WebFilter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HazelSessionListener  implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HazelSessionListener sessionCreated");
       // System.out.println("hazel session =" + super.getId());
        HttpSession session = httpSessionEvent.getSession();

        ServletContext servletContext = session.getServletContext();
        WebFilter webFilter = (WebFilter) servletContext.getAttribute(WebFilter.class.getName());
        Enumeration enumeration = httpSessionEvent.getSession().getAttributeNames();
        Map<String, Object> existingElements = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            existingElements.put(name, session.getAttribute(name));
        }
        if (!existingElements.isEmpty()) {
        try {
            System.out.println("session elements" + existingElements.size());


           // webFilter.getClusteredSessionService().updateAttributes(session.getId(), existingElements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
            session = (HazelcastHttpSession)session;
            System.out.println("session Id = "+ session.getId());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDestroyed");
    }
}
