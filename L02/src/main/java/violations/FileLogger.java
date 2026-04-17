/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jacks
 */
public class FileLogger {

    public void log(String message) {
        try (FileWriter writer = new FileWriter("app.log", true)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timestamp + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error escribiendo log: " + e.getMessage());
        }
    }
}
