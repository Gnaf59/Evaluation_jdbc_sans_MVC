package metier;

import java.awt.TextField;
import java.util.Date;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dev
 */
public class Representation extends Spectacle{
    private int numeroRepresentation,numSalle;
    private double tarif;
    private Date dateRepresentation;

    public int getNumeroRepresentation() {
        return numeroRepresentation;
    }

    public void setNumeroRepresentation(int numeroRepresentation) {
        this.numeroRepresentation = numeroRepresentation;
    }


    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Date getDateRepresentation() {
        return dateRepresentation;
    }

    public void setDateRepresentation(Date dateRepresentation) {
        this.dateRepresentation = dateRepresentation;
    }
    
    public String toString()
    {
        return dateRepresentation+" "+getNomSpectacle();
    }
    
    
    
}
