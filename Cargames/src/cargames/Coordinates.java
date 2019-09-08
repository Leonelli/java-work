package cargames;

class Coordinates {

    // Coordinates x and y
    private final int x, y;

    /**
     * Constructor of the class Coordinates
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of the field x
     * @return The value of the x field
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter of the field y
     * @return The value of the y field
     */
    public int getY() {
        return this.y;
    }
}