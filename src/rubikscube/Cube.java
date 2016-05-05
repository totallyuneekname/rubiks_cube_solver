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
public class Cube {

    private Color[][][] colorValues = new Color[6][3][3];
    Color currentFront = new Color("w");
    Color currentTop = new Color("b"); // these will CHANGE
    Color[][] axes = {{new Color("w"), new Color("o"), new Color("y"), new Color("r")},
    {new Color("w"), new Color("b"), new Color("y"), new Color("g")},
    {new Color("b"), new Color("r"), new Color("g"), new Color("o")}};

    public Cube() {
        // The following cube is to create a "solved" cube
        int sideCounter = 1;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    colorValues[i - 1][j][k] = new Color(i);
                }
            }
            sideCounter++;
        }
        // end
    }

    public void changeFront(String newFront) {
        currentFront = new Color(newFront);
    }

    public void changeTop(String newTop) {
        currentFront = new Color(newTop);
    }

    public void makeMove(String move) {
        int numOfRotations = 1;
        boolean isReverse = false;
        String side = move.substring(0, 1).toLowerCase();
        if (move.length() > 1) {
            if (move.substring(1, 2).equals("'")) {
                isReverse = true;
                if (move.length() > 2) {
                    numOfRotations = Integer.parseInt(move.substring(2));
                }
            } else {
                numOfRotations = Integer.parseInt(move.substring(1));
            }
        }
        switch (side) {
            case "f":
                turnSide(currentFront, isReverse, numOfRotations);
                break;
            case "u":
                turnSide(currentTop, isReverse, numOfRotations);
                break;
            case "r":
                if (currentFront.getIntegerVal() > 0 && currentFront.getIntegerVal() < 6) {
                    turnSide(new Color(currentFront.getIntegerVal() + 1), isReverse, numOfRotations);
                }
                break;
            case "l":
                //
                break;
            case "b":
                //
                break;
            case "d":
                //
                break;
            default:
                System.out.println("That move is invalid.");
        }
    }

    public void turnSide(Color side, boolean reverse, int num) {
        //Rearrange array of given side
        Color[][] tempSide = colorValues[side.getIntegerVal()];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (reverse) {
                    //Flip counterclockwise
                } else {
                    //flip clockwise
                }
            }
        }
        colorValues[side.getIntegerVal()] = tempSide;
        //Shift affected sides
        Color[] affectedSides = {};
        for (Color[] axis : axes) {
            boolean existsInAxis = false;
            for (Color c : axis) {
                if (c.equals(side)) {
                    existsInAxis = true;
                }
            }
            if (!existsInAxis) {
                affectedSides = axis;
                break;
            }
        }
        // temporary loop to test code
        for (Color c : affectedSides) {
            System.out.println(c.getColor());
        }
        //end of temp loop
    }

    public void printCube() {
        for (int i = 0; i < 3; i++) {
            System.out.println("            —————————————");
            String nextLine = "            |";
            for (int j = 0; j < 3; j++) {
                nextLine += (" " + colorValues[currentTop.getIntegerVal()][i][j].getColor() + " |");
            }
            System.out.println(nextLine);
        }
        System.out.println("—————————————————————————————————————————————————");
        for (int i = 0; i < 3; i++) {
            String nextLine = "|";
            for (int j = 1; j < 5; j++) {
                for (int k = 0; k < 3; k++) {
                    nextLine += (" " + colorValues[j][i][k].getColor() + " |");
                }
            }
            System.out.println(nextLine);
            System.out.println("—————————————————————————————————————————————————");
        }
        for (int i = 0; i < 3; i++) {
            String nextLine = "            |";
            for (int j = 0; j < 3; j++) {
                nextLine += (" " + colorValues[5][i][j].getColor() + " |");
            }
            System.out.println(nextLine);
            System.out.println("            —————————————");
        }
    }
}
