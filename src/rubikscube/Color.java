/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikscube;

/**
 *
 * @author student
 */
public class Color {

    private int colorValue;
    String[] colorLetters = {"O", "W", "R", "Y", "B", "G"};

    public Color(int colorValue) {
        this.colorValue = colorValue;
    }
    public Color(String color) {
        color = color.toUpperCase();
        for (int i = 1; i <= colorLetters.length; i++) {
            if (colorLetters[i-1].equals(color)) {
                colorValue = i;
                return;
            }
        }
        System.out.println("Letter is not a valid color.");
    }
    
    public String getColor() {
        return this.colorLetters[this.colorValue - 1];
    }
    public int getIntegerVal() {
        return this.colorValue;
    }
}