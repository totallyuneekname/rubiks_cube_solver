/*
 * Copyright (C) 2016 Jacob
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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