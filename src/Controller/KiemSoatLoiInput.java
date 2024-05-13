/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaiser
 */
public class KiemSoatLoiInput {

    public static boolean kiemtraEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static boolean kiemtraTrongInput(String input) {
        return input == null || input.trim().isEmpty();
    }
}
