/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gauthier.application;

import com.gauthier.entities.BaseDeDonnee;

/**
 *
 * @author Dev
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDeDonnee bdd=new BaseDeDonnee();
        bdd.remplirCollections();
        new EcranReservation();
    }
    
}
