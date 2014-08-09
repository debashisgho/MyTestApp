/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.mytestapp.mytestapp.resources;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
/**
 *
 * @author DGH
 */
@Stateless
@Path("/resource")
public class MyResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
   
    public String MyResource() {
        String message;
        if(SecurityUtils.getSubject().getPrincipal().toString()== null){
            message ="can't find user id";
        }
        else
            message = "found user id = "+SecurityUtils.getSubject().getPrincipal().toString();
            if(SecurityUtils.getSubject().isAuthenticated()){
                message = message+" the user is authenticated";
                String role ="admin";                
                message = message +"user has access to role "+role+" "+SecurityUtils.getSubject().hasRole(role);
            }
        return message;
 
        
        
    }
    
  
}
