/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_03.problema;

/**
 *
 * @author jacks
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameSession session = new GameSession();
        NetworkManager network = new NetworkManager();
        DatabaseManager database = new DatabaseManager();

        session.startSession();    // maxPlayers = 50, debug = false
        network.connect();         // debug = true (inconsistente!)
        database.saveData();       // databaseUrl diferente (inconsistente!)
    }
    
}
