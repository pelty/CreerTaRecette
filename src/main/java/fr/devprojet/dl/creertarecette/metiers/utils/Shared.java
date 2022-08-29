/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author dev-pro
 */
public class Shared {
    public static final String IMAGES_FOLDER = "/aPath/Images";
    
    public static final Key SECRET_KEY = 
            new SecretKeySpec( "Une clé secrête : chut !!!!!!!".getBytes(), "AES" );
}
