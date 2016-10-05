/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interBD;
import metier.Adherent;
import metier.Representation;
import java.sql.*; 
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracle.jdbc.driver.*;
/**
 *
 * @author Dev
 */
public class GestionDonnees {
    
    //url du serveur oracle
   private String url="jdbc:oracle:thin:@localhost:1521:xe";
   //nom d'utilisateur oracle
   private String user = "Test";
   //mot de passe de la base oracle
   private String password = "motdepasse";
   //connection à la base de donnée
   private Connection connection=null;
   
   private static ArrayList<Adherent> adherentList=new ArrayList<>();
   private static ArrayList<Representation> representationList=new ArrayList<>();

    public GestionDonnees() {
        try 
        {
            Class.forName( "oracle.jdbc.driver.OracleDriver" );
        } 
        catch ( ClassNotFoundException e ) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur chargement driver jdbc", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void getConnection()
    {
        try
        {
            connection= DriverManager.getConnection(url,user,password);
        }
        catch(SQLException sqlex)
        {
            //gère l'exception en cas d'ouverture de la connection impossible
           JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Ouverture de connection impossible", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void closeConnection()
    {
        if ( connection != null )
                    try {
                            
                            connection.close();
                        } 
                    catch ( SQLException ignore ) 
                        {
                            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                        }   
    }
    
    public void remplirCollections()
    {
        getConnection();
            
            try{
                ResultSet resultatRequete;
                String query= "SELECT * FROM ADHERENT";
                Statement statement = connection.createStatement();
                resultatRequete= statement.executeQuery(query);
                
                while(resultatRequete.next())
                {
                    Adherent adherent=new Adherent();
                    adherent.setNumeroAdherent(resultatRequete.getInt(1));
                    adherent.setNomAdherent(resultatRequete.getString(2));
                    adherent.setPrenomAdherent(resultatRequete.getString(3));
                    adherent.setAdresseAdherent(resultatRequete.getString(4));
                    adherentList.add(adherent);
                }
                
                query="SELECT * FROM SPECTACLE,REPRESENTATION WHERE SPECTACLE.NUMSPECTACLE = REPRESENTATION.NUMSPECTACLE";
                resultatRequete=statement.executeQuery(query);
                while(resultatRequete.next())
                {
                    Representation representation=new Representation();
                    representation.setNumeroSpectacle(resultatRequete.getInt(1));
                    representation.setNomSpectacle(resultatRequete.getString(2));
                    representation.setGenreSpectacle(resultatRequete.getString(3));
                    representation.setDureeSpectacle(resultatRequete.getInt(4));
                    representation.setNumeroRepresentation(resultatRequete.getInt(5));
                    representation.setNumSalle(resultatRequete.getInt(7));
                    representation.setDateRepresentation(resultatRequete.getDate(8));
                    representation.setTarif(resultatRequete.getDouble(9));
                    representationList.add(representation);
                }
                
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Problème requête SELECT", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                closeConnection();
            }
            
        
    }

    public static ArrayList<Adherent> getAdherentList() {
        return adherentList;
    }

    public static ArrayList<Representation> getRepresentationList() {
        return representationList;
    }
    public static void calculTotal(JTextField tfTotal,JTextField tfNombrePersonne,JComboBox cbRepresentation )
    {
        try{
            Representation repr;
            repr=getRepresentationList().get(cbRepresentation.getSelectedIndex());
            double calcul=(repr.getTarif())*(Double.parseDouble(tfNombrePersonne.getText()));
            tfTotal.setText(String.valueOf(calcul));
            //System.out.println(repr.getTarif());
        }
        catch(NumberFormatException nfe)
        {
            tfTotal.setText("0");
        }
        
    }
    
    public void enregistrementReservation(Representation representation,Adherent adherent,Integer nbrPersonne) throws SQLException
    {
        String query= "INSERT INTO RESERVATION (NUMADHERENT, NUMREPRESENTATION, NBPERSONNES, DATERESA) "
                + "VALUES ("+adherent.getNumeroAdherent()+", "+representation.getNumeroRepresentation()+", "+nbrPersonne+", TO_DATE('"+representation.getDateRepresentation()+"', 'YYYY-MM-DD'))";
        
        
            Statement statement = connection.createStatement();    
            statement.executeUpdate(query);
    }
    
    
}
