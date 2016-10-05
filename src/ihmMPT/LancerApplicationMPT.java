/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihmMPT;

import interBD.GestionDonnees;

/**
 *
 * @author Dev
 */
public class LancerApplicationMPT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionDonnees bdd=new GestionDonnees();
        bdd.remplirCollections();
        new IHMReservations();
    }
    
}
