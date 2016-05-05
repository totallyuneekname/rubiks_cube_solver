/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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