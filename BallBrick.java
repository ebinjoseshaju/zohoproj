import java.util.Arrays;
import java.util.Scanner;

/**
 * Java Program to initialize and print two dimensional array in Java.
 * 
 * @author WINDOWS 8
 *
 */
class Ball {

    public static int n=0;
    public static int life;
    public static String[][] mat;

    public static void main(String args[]) {

        int pli;
        int plj;
        String typ;
        char choice;
        // int life;
        String move;
        int balposi = 0, balposj = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of NxN matrix: ");
        // reading the number of elements from the that we want to enter
        n = sc.nextInt();
        // initializing two dimensional array as literal
        mat = new String[n][n];

        // how to initialize two dimensional array in Java
        // using for loop

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || j == (n - 1))
                    mat[i][j] = "W";
                else if (i == (n - 1)) {
                    mat[i][j] = "G";
                    if (j == ((n - 1) / 2)) {
                        mat[i][j] = "o";
                        balposi = i;
                        balposj = j;
                    }

                } else
                    mat[i][j] = " ";

            }
        }
        System.out.println();
        do {

            System.out.print("Enter the brick position and the brick type: ");
            pli = sc.nextInt();
            plj = sc.nextInt();
            typ = sc.next();
            if (pli != 0 || plj != 0 || plj != (n - 1) || pli != (n - 1))
                mat[pli][plj] = typ;
            else
                System.out.println("cannot place brick on the wall or ground");
            System.out.print("Do you want to continue(Y or N)?");
            choice = sc.next().charAt(0);

        } while (choice != 'N' && choice != 'n');
        System.out.print("Enter ball count : ");
        life = sc.nextInt();

        // now let's print a two dimensional array in Java
        printMatrix();
        do {
            System.out.print("Enter the direction in which the ball needs to traverse : ");
            move = sc.next();
            if (move.equals("ST")) {
                for (int a = balposi - 1; a > 0; a--) {
                    if ((mat[a][balposj].equals(" ")) == false) {
                        if (isNumeric(mat[a][balposj])) {
                            mat[a][balposj] = String.valueOf(Integer.parseInt(mat[a][balposj]) - 1);
                            if (mat[a][balposj].equals("0"))
                                mat[a][balposj] = " ";
                            a = 0;
                        } else if (mat[a][balposj].equals("DE")) {
                            for (int b = 1; b < n - 1; b++) {
                                mat[a][b] = " ";
                            }
                            a = 0;
                        } else if (mat[a][balposj].equals("DS")) {
                            mat[a][balposj] = " ";
                            mat[a + 1][balposj + 1] = " ";
                            mat[a - 1][balposj - 1] = " ";
                            mat[a + 1][balposj - 1] = " ";
                            mat[a - 1][balposj + 1] = " ";
                            mat[a + 1][balposj] = " ";
                            mat[a][balposj + 1] = " ";
                            mat[a - 1][balposj] = " ";
                            mat[a][balposj - 1] = " ";
                            a = 0;

                        }

                    }
                }
            } 
            else if (move.equals("LD")) 
            {
                for (int c = balposi - 1, d = balposj - 1; d >= 0; c--, d--) {
                    if ((mat[c][d].equals(" ")) == false) {
                        if (isNumeric(mat[c][d])) {
                            mat[c][d] = String.valueOf(Integer.parseInt(mat[c][d]) - 1);
                            if (mat[c][d].equals("0"))
                                mat[c][d] = " ";

                            mat[balposi][balposj] = "G";
                            if(balposj != d)
                            life--;
                            balposj = d;
                            mat[balposi][balposj] = "o";
                            d = -1;
                        } else if (mat[c][d].equals("DE")) {
                            for (int b = 1; b < n - 1; b++) {
                                mat[c][b] = " ";
                            }
                            mat[balposi][balposj] = "G";
                            if(balposj != d)
                            life--;
                            balposj = d;
                            mat[balposi][balposj] = "o";
                            d = -1;
                        } else if (mat[c][d].equals("DS")) {
                            mat[c][d] = " ";
                            mat[c + 1][d + 1] = " ";
                            mat[c - 1][d - 1] = " ";
                            mat[c + 1][d - 1] = " ";
                            mat[c - 1][d + 1] = " ";
                            mat[c + 1][d] = " ";
                            mat[c][d + 1] = " ";
                            mat[c - 1][d] = " ";
                            mat[c][d - 1] = " ";
                            mat[balposi][balposj] = "G";
                            if(balposj != d)
                            life--;
                            balposj = d;
                            mat[balposi][balposj] = "o";
                            d = -1;

                        } else if (mat[c][d].equals("W")) {
                            for (int b = 1; b <=n - 1; b++) {
                                if ((mat[c][b].equals(" ")) == false) {
                                    if (isNumeric(mat[c][b])) {
                                        mat[c][b] = String.valueOf(Integer.parseInt(mat[c][b]) - 1);
                                        if (mat[c][b].equals("0"))
                                            mat[c][b] = " ";

                                        mat[balposi][balposj] = "G";
                                        if(balposj != b)
                                           life--;
                                        balposj = b;
                                         mat[balposi][balposj] = "o";
                                        b = n - 1;
                                    } else if (mat[c][b].equals("DE")) {
                                        for (int x = 1; x < n - 1; x++) {
                                            mat[c][x] = " ";
                                        }
                                        mat[balposi][balposj] = "G";
                                        if(balposj != b)
                                           life--;
                                        balposj = b;
                                         mat[balposi][balposj] = "o";
                                        b = n - 1;
                                    } else if (mat[c][b].equals("DS")) {
                                        mat[c][d] = " ";
                                        mat[c + 1][d + 1] = " ";
                                        mat[c - 1][d - 1] = " ";
                                        mat[c + 1][d - 1] = " ";
                                        mat[c - 1][d + 1] = " ";
                                        mat[c + 1][d] = " ";
                                        mat[c][d + 1] = " ";
                                        mat[c - 1][d] = " ";
                                        mat[c][d - 1] = " ";
                                        mat[balposi][balposj] = "G";
                                        if(balposj != b)
                                           life--;
                                        balposj = b;
                                         mat[balposi][balposj] = "o";
                                        b = n - 1;

                                    } else if (mat[c][b].equals("W")){
                                        System.out.println("Ball Lost");
                                        life--;
                                        mat[balposi][balposj] = "G";
                                        balposi = n-1;
                                        balposj =(n-1)/2;
                                        mat[balposi][balposj] = "o";
                                    }
                                        
                                    }

                                }
                            }

                        }
                    }
                }
            
            else if (move.equals("RD")) 
            {
                for (int c = balposi - 1, d = balposj + 1; d <=n-1; c--, d++) {
                    if ((mat[c][d].equals(" ")) == false) {
                        if (isNumeric(mat[c][d])) {
                            mat[c][d] = String.valueOf(Integer.parseInt(mat[c][d]) - 1);
                            if (mat[c][d].equals("0"))
                                mat[c][d] = " ";

                                mat[balposi][balposj] = "G";
                                if(balposj != d)
                                life--;
                                balposj = d;
                                mat[balposi][balposj] = "o";
                            d = n;
                        } else if (mat[c][d].equals("DE")) {
                            for (int b = 1; b < n - 1; b++) {
                                mat[c][b] = " ";
                            }
                            mat[balposi][balposj] = "G";
                            if(balposj != d)
                            life--;
                            balposj = d;
                            mat[balposi][balposj] = "o";
                            d = n;
                        } else if (mat[c][d].equals("DS")) {
                            mat[c][d] = " ";
                            mat[c + 1][d + 1] = " ";
                            mat[c - 1][d - 1] = " ";
                            mat[c + 1][d - 1] = " ";
                            mat[c - 1][d + 1] = " ";
                            mat[c + 1][d] = " ";
                            mat[c][d + 1] = " ";
                            mat[c - 1][d] = " ";
                            mat[c][d - 1] = " ";
                            mat[balposi][balposj] = "G";
                            if(balposj != d)
                            life--;
                            balposj = d;
                            mat[balposi][balposj] = "o";
                            d = n;

                        } else if (mat[c][d].equals("W")) {
                            for (int b = n-2; b >= 0; b--) {
                                if ((mat[c][b].equals(" ")) == false) {
                                    if (isNumeric(mat[c][b])) {
                                        mat[c][b] = String.valueOf(Integer.parseInt(mat[c][b]) - 1);
                                        if (mat[c][b].equals("0"))
                                            mat[c][b] = " ";

                                            mat[balposi][balposj] = "G";
                                            if(balposj != b)
                                               life--;
                                            balposj = b;
                                             mat[balposi][balposj] = "o";
                                        b = -1;
                                    } else if (mat[c][b].equals("DE")) {
                                        for (int x = 1; x < n - 1; x++) {
                                            mat[c][x] = " ";
                                        }
                                        mat[balposi][balposj] = "G";
                                        if(balposj != b)
                                           life--;
                                        balposj = b;
                                         mat[balposi][balposj] = "o";
                                        b = -1;
                                    } else if (mat[c][b].equals("DS")) {
                                        mat[c][d] = " ";
                                        mat[c + 1][d + 1] = " ";
                                        mat[c - 1][d - 1] = " ";
                                        mat[c + 1][d - 1] = " ";
                                        mat[c - 1][d + 1] = " ";
                                        mat[c + 1][d] = " ";
                                        mat[c][d + 1] = " ";
                                        mat[c - 1][d] = " ";
                                        mat[c][d - 1] = " ";
                                        mat[balposi][balposj] = "G";
                                        if(balposj != b)
                                           life--;
                                        balposj = b;
                                         mat[balposi][balposj] = "o";
                                        b = -1;

                                    } else if (mat[c][b].equals("W")){
                                        System.out.println("Ball Lost");
                                        life--;
                                        mat[balposi][balposj] = "G";
                                        balposi = n-1;
                                        balposj =(n-1)/2;
                                        mat[balposi][balposj] = "o";
                                    }

                                }
                            }

                        }
                    }
                }
            }
            printMatrix();
        } while ((!isEmpty())&&(life>0));

        if(life!=0)
        System.out.println("You win HURRAY..!!");
        else
        System.out.println("You lost TRY AGAIN..!!");
    }

    public static void printMatrix() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.print("Ball count is : " + life);
        System.out.println("\n");
    }

    public static boolean isEmpty() {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (mat[i][j] != " ")
                    return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        int intValue;

        // System.out.println(String.format("Parsing string: \"%s\"", string));

        if (str == null || str.equals("")) {
            // System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

}
