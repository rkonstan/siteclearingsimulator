package com.tdd;

import static java.lang.Integer.parseInt;

public class SiteClearingSimulator {
    private int movesForwardWidth = 0;
    private int movesForwardLength = 0;
    private String orientation = SiteClearingConstants.EAST;

    public String getBulldozerPosition(int width, int length, String command) {
        if (command.isBlank()) {
            orientation = SiteClearingConstants.EAST;
        }

        if (command.startsWith(SiteClearingConstants.ACTION) && movesForwardWidth == 0) {
            movesForwardWidth = parseInt(command.replace(SiteClearingConstants.ACTION,
                    SiteClearingConstants.EMPTY));
        } else if (command.startsWith(SiteClearingConstants.ACTION) && movesForwardLength == 0) {
            movesForwardLength = parseInt(command.replace(SiteClearingConstants.ACTION,
                    SiteClearingConstants.EMPTY));
        }

        if (movesForwardWidth < 0 || movesForwardLength < 0 ||
                movesForwardWidth >= width || movesForwardLength >= length) {
            return SiteClearingConstants.DEFAULT_POSITION;
        }

        if (command.equals(SiteClearingConstants.LEFT)) {
             orientation = SiteClearingConstants.NORTH;
        } else if (command.equals(SiteClearingConstants.RIGHT)) {
             orientation = SiteClearingConstants.EAST;
        }

        String[][] siteArea = new String[width][length];
        displaySiteArea(siteArea);

        String position = String.format("%s,%s,%s", movesForwardWidth, movesForwardLength, orientation);
        return position;
    }

    private void displaySiteArea(String[][] siteArea) {
        int resetOrigin = siteArea.length - 1;
        for (int i = 0; i < siteArea.length; i++) {
            System.out.println();
            for (int j = 0; j < siteArea[i].length; j++) {
                siteArea[i][j] = ".";
                siteArea[resetOrigin - movesForwardLength][movesForwardWidth] = "X";
                System.out.print(siteArea[i][j] + " ");
            }
        }
        System.out.println();
    }
}

