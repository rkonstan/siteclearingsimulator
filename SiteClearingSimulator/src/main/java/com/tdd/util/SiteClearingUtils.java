package com.tdd.util;

import com.tdd.constants.SiteClearingConstants;
import static java.lang.Integer.parseInt;

public class SiteClearingUtils {

    // displays the position of the bulldozer on a grid marked X.
    public static void displaySiteArea(String[][] siteArea, int movesForwardWidth, int movesForwardHeight) {
        int resetOrigin = siteArea.length - 1;
        for (int i = 0; i < siteArea.length; i++) {
            System.out.println();
            for (int j = 0; j < siteArea[i].length; j++) {
                siteArea[i][j] = ".";
                siteArea[resetOrigin - movesForwardHeight][movesForwardWidth] = "X";
                System.out.print(siteArea[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static int getNumberOfMovesFromCommand(String command) {
        int movesForward;
        movesForward = parseInt(command.replace(SiteClearingConstants.ACTION,
                SiteClearingConstants.EMPTY));
        return movesForward;
    }

    public static boolean isActionCommand(String command) {
        if (command.startsWith(SiteClearingConstants.ACTION)) {
            return true;
        }
        return false;
    }

}
