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
public class Cube {

    private Color[][][] colorValues = new Color[6][3][3];
    Color currentFront;
    Color currentTop; // these will CHANGE
    Color[][] axes = {{new Color("w"), new Color("o"), new Color("y"), new Color("r")},
    {new Color("w"), new Color("b"), new Color("y"), new Color("g")},
    {new Color("b"), new Color("r"), new Color("g"), new Color("o")}};

    public Cube(String front, String top) {
        currentFront = new Color(front);
        currentTop = new Color(top);
        // The following cube is to create a "solved" cube
        int sideCounter = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    colorValues[i][j][k] = new Color(i);
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
        currentTop = new Color(newTop);
    }
    
    public int getSideInt(String side) {
        for (int i = 0; i < 6; i++) {
            if (colorValues[i][1][1].getColor().equals(side)) return i;
        }
        return -1;
    }

    public void parseMove(String move) {
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
                    tempSide[2-j][2-1] = colorValues[side.getIntegerVal()][i][j];
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
    public void printSide(String side) {
        int sideNum = getSideInt(side);
        //System.out.println("side int is ");
        System.out.println("—————————————");
        for (int i = 0; i < 3; i++) {
            String nextLine = "|";
            for (int j = 0; j < 3; j++) {
                nextLine += (" " + colorValues[sideNum][i][j].getColor() + " |");
            }
            System.out.println(nextLine);
            System.out.println("—————————————");
        }
    }
}
