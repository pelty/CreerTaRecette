/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.creertarecette.metiers.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dev-pro
 */
public class DictionnaireMimeType {
    transient public static final Map acceptedMimeType = new HashMap();
    static{
        acceptedMimeType.put("jpg", "image/jpeg");
        acceptedMimeType.put("gif", "image/gif");
        acceptedMimeType.put("png", "image/png");
        acceptedMimeType.put("tif", "image/tiff");
        acceptedMimeType.put("svg", "image/svg+xml");
        acceptedMimeType.put("ico", "image/vnd.microsoft.icon");
    }
}
