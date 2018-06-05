/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.models;

import java.text.DecimalFormat;

/**
 *
 * @author rojul
 */
public class SimpatikUtils {
     public static String formatUang(double uang) {
        DecimalFormat myFormatter = new DecimalFormat("###,###,###");
        String output = myFormatter.format(uang);
        return output;
    }
}               
