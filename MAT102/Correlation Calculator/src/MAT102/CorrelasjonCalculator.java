package MAT102;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.String.valueOf;

public class CorrelasjonCalculator {

    //Decides size on cells in the printed matrix
    final static int SPACING = 16;

    public static void main (String[] args) {

        //x values in first column, y values in first row. [0][0] is not used.
        //Probabilities in the 'middle', no need to insert the sum of x and y.
        double[][] pD1 = {
                {0, 5   , 6   , 7   },
                {1, 0.0194, 0.5510, 0.1471},
                {2, 0.0626 , 0.1148 , 0.1051},
        };
        double[][] pD2 = {
                {0, 1   , 2   , 3,   },
                {0, 0.02, 0.06, 0.02,},
                {1, 0.1 , 0.3 , 0.1 ,},
                {2, 0.08, 0.24, 0.08,},
        };

        //Select which matrix to use
        double[][] pDist = pD1;

        //Variables
        int lengthX = pDist[0].length;
        int lengthY = pDist.length;
        BigDecimal[] probSumX = new BigDecimal[lengthX-1];
        BigDecimal[] probSumY = new BigDecimal[lengthY-1];
        StringBuilder calcString = new StringBuilder("Calculations Below:").append("\n\nMean (E):\nE(X) = ");

        //Calculates the sum of the probabilities and puts them in array.
        for (int indexX = 1; indexX < lengthX; indexX++) {
            probSumX[indexX-1] = BigDecimal.valueOf(0);

            for (int indexY = 1; indexY < lengthY; indexY++) {
                if (probSumY[indexY-1] == null) {
                    probSumY[indexY-1] = BigDecimal.valueOf(0);
                }
                probSumX[indexX-1] = probSumX[indexX-1].add(BigDecimal.valueOf(pDist[indexY][indexX]));
                probSumY[indexY-1] = probSumY[indexY-1].add(BigDecimal.valueOf(pDist[indexY][indexX]));
            }
        }

        //Calculates Mean of X.
        BigDecimal meanX = BigDecimal.valueOf(0);

        for (int i = 0; i < lengthX - 1; i++) {
            calcString.append("(").append(pDist[0][i+1]).append(" * ").append(probSumX[i]).append(")");
            if (i < lengthX - 2) {
                calcString.append(" + ");
            }
            meanX = meanX.add(BigDecimal.valueOf(pDist[0][i+1]).multiply(probSumX[i]));
        }
        calcString.append("\n     = ").append(meanX).append("\n\nE(Y) = ");

        //Calculates Mean of Y.
        BigDecimal meanY = BigDecimal.valueOf(0);

        for (int i = 0; i < lengthY - 1; i++) {
            calcString.append("(").append(pDist[i+1][0]).append(" * ").append(probSumY[i]).append(")");
            if (i < lengthY - 2) {
                calcString.append(" + ");
            }
            meanY = meanY.add(BigDecimal.valueOf(pDist[i+1][0]).multiply(probSumY[i]));
        }
        calcString.append("\n     = ").append(meanY).append("\n\nVariation (σ^2 / Var) and Standard Deviation (σ / STD):\nVar(x) = ");

        //Calculates Var and STD of X.
        BigDecimal varX = BigDecimal.valueOf(0);

        for (int i = 0; i < lengthX - 1; i++) {
            calcString.append("(").append(pDist[0][i+1]).append(" - ").append(meanX).append(")^2 * ").append(probSumX[i]);
            if (i < lengthX - 2) {
                calcString.append(" + ");
            }
            varX = varX.add((BigDecimal.valueOf(pDist[0][i+1]).subtract(meanX)).pow(2).multiply(probSumX[i]));
        }
        BigDecimal stdX = varX.sqrt(new MathContext(6));
        calcString.append("\n       = ").append(varX).append("\n\n    σx = ").append(stdX).append("\n\nVar(y) = ");

        //Calculates Var and STD of Y.
        BigDecimal varY = BigDecimal.valueOf(0);

        for (int i = 0; i < lengthY - 1; i++) {
            calcString.append("(").append(pDist[i+1][0]).append(" - ").append(meanY).append(")^2 * ").append(probSumY[i]);
            if (i < lengthY - 2) {
                calcString.append(" + ");
            }
            varY = varY.add((BigDecimal.valueOf(pDist[i+1][0]).subtract(meanY)).pow(2).multiply(probSumY[i]));
        }

        BigDecimal stdY = varY.sqrt(new MathContext(6));
        calcString.append("\n       = ").append(varY).append("\n\n    σy = ").append(stdX);

        //Calculates Covariation
        calcString.append("\n\nCovariation (Cov):\nCov(X,Y) = ");
        BigDecimal covXY = BigDecimal.valueOf(0);

        for (int indexY = 1; indexY < lengthY; indexY++) {
            for (int indexX = 1; indexX < lengthX; indexX++) {
                BigDecimal X = BigDecimal.valueOf(pDist[0][indexX]);
                BigDecimal Y = BigDecimal.valueOf(pDist[indexY][0]);

                if (indexX != 1 || indexY != 1) {
                    calcString.append("         + ");
                }
                calcString.append("(").append(X).append("-").append(meanX).append(")(").append(Y).append("-").append(meanY).append(")*").append(pDist[indexY][indexX]).append("\n");
                BigDecimal probValue = BigDecimal.valueOf(pDist[indexY][indexX]);
                covXY = covXY.add(X.subtract(meanX).multiply(Y.subtract(meanY)).multiply(probValue));
            }
        }
        calcString.append("Cov(X,Y) = ").append(covXY.setScale(10, RoundingMode.CEILING));

        //Calculates Corelation
        calcString.append("\n\nCorrelation (p):\np(X,Y) = Cov(X,Y) / (σx*σy)\n       = ").append(covXY).append(" / (").append(stdX).append(" * ").append(stdY).append(")");
        calcString.append("\n       = ").append(covXY.divide(stdX.multiply(stdY),20, RoundingMode.CEILING));

        printMatrix(pDist, probSumX, probSumY);
        System.out.println(calcString + "\n\nDone!");
    }

    public static void printMatrix(double[][] mat, BigDecimal[] sumX, BigDecimal[] sumY) {
        StringBuilder str = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < mat.length; i++) {
            for (double d : mat[i]) {
                if (first) {
                    str.append("Probability Matrix:\n").append(longLine(mat[0].length+1)).append(formatData("y   |   x"));
                    first = false;
                } else {
                    str.append(formatData(valueOf(d)));
                }
            }
            if (i == 0) {
                str.append(formatData("Sum y"));
            } else {
                str.append(formatData(valueOf(sumY[i-1])));
            }
            str.append("|\n").append(longLine(mat[0].length+1));
        }
        str.append(formatData("Sum x"));

        for (int i = 0; i < mat[0].length-1; i++) {
            str.append(formatData(valueOf(sumX[i])));
        }
        str.append(formatData("1"));
        str.append("|\n").append(formatData("-".repeat(SPACING)).repeat(mat[0].length+1)).append("|\n");
        System.out.println(str);
    }

    public static String formatData(String str) {
        StringBuilder line = new StringBuilder();

        int spaces = SPACING - (str.length());

        if (str.length() % 2 == 0) {
            line.append(" ".repeat(Math.max(0, (spaces / 2))));
        } else {
            line.append(" ".repeat(Math.max(0, (spaces / 2) + 1)));
        }
        line.append(str).append(" ".repeat(Math.max(0, (spaces / 2))));
        return "|" + line;
    }

    public static String longLine(int length) {
        return formatData("-".repeat(SPACING)).repeat(length) + ("|\n");
    }
}
