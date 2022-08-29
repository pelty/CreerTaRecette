/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.v1.controllers;

import fr.devprojet.dl.creertarecette.daopg.DaoFactory;
import fr.devprojet.dl.creertarecette.dao.implementation.UserImplement;
import fr.devprojet.dl.creertarecette.entities.Users;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

/**
 *
 * @author dev-pro
 */
@Path("/user")
@PermitAll
public class UserControllers {
    private final UserImplement userImplement =  DaoFactory.getInstance().getUserImplement();
    
    public Response login(String pseudo, String password){
        return null;
    }
    
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List<Users> list = userImplement.findAll();
        return Response
                .status(201)
                .entity(list)
                .build();
    }
    
    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Users users){
        users = userImplement.create(users);
        return Response
                .status(201)
                .entity(users)
                .build();
    }
    
    @Path("/update/{id}")
    @PUT
    @RolesAllowed("Manager")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Users users, @PathParam("id") long id){
        //users = userImplement.update(users, id);
        users = userImplement.update(users,id);
        if(users != null){
            return Response
                .status(201)
                .entity("update reussi "+ users)
                .build();
        }
        
        return Response
                .status(404)
                .entity("Err : Update user")
                .build();
        
    }
    
    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTest(){
        return Response
                .status(201)
                .entity("Test reussi")
                .build();
    }
    
    

    
    
    
    
    
    
}


/**
 * @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Users users, @PathParam("id") long id){
        //users = userImplement.update(users, id);
        users = userImplement.update(users);
        if(users != null){
            return Response
                .status(201)
                .entity("update reussi")
                .build();
        }
        
        return Response
                .status(404)
                .entity("Err : Update user")
                .build();
        
    }
 */