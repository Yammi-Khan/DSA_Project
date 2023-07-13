/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.SwingUtilities;
import ui.CarShowroomSystem;

/**
 *
 * @author Hi
 */
public class Main {
    public static void main(String[] args) {
           
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CarShowroomSystem();
            }
        });
    }
}
