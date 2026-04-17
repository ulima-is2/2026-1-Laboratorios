/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public class EmailNotifier {

    public void sendEmail(String recipient, String subject, String message) {
        System.out.println("Enviando email a " + recipient);
        System.out.println("Asunto: " + subject);
        System.out.println("Mensaje: " + message);
    }
}
