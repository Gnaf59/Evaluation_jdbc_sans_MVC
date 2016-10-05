/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Dev
 */
public class Adherent {
    
    private String nomAdherent,prenomAdherent,adresseAdherent;
    private int numeroAdherent;
    public String getNomAdherent() {
        return nomAdherent;
    }

    public void setNomAdherent(String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    public String getAdresseAdherent() {
        return adresseAdherent;
    }

    public void setAdresseAdherent(String adresseAdherent) {
        this.adresseAdherent = adresseAdherent;
    }

    public int getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }
    
    @Override
    public String toString()
    {
        return nomAdherent.trim()+" "+prenomAdherent.trim();
    }
    
}
