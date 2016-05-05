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

import java.util.Scanner;

/**
 *
 * @author student
 */
public class SolveCube {
    
    public void solveCross() {
        //This method will solve the cross of the cube
    }
    
    public void solveSides() {
        //This method will solve the sides of the cube, using algorithms
    }
    
    public void solveTopCross() {
        //This method will solve the top cross of the cube
    }
    
    public void solveTopCorners() {
        //This method will solve the top corners of the cube (but they may not be in the right positions!)
    }
    
    public void solveHeadlights() {
        //This method will correctly permutate the top corners.
    }

    
    public static void main(String[] args) {
        Cube rubik = new Cube();
        Scanner reader = new Scanner(System.in);
        while (true) {
        String input = reader.nextLine();
        if (input.equals("print")) rubik.printCube();
        else if (input.equals("quit")) break;
        else if (input.substring(0, input.length()-1).equals("front ")) rubik.changeFront(input.substring(input.length()-1));
        else rubik.makeMove(input);
        }
    }
}