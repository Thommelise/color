

public class Colour {


    int red;
    int green;
    int blue;

    public Colour(int red, int green, int blue) {

        this.red = red;

        this.green = green;

        this.blue = blue;
    }


    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isGrey() {
        if (red == blue && red == green) {
            return true;
        }
        return false;
    }

    public void mixWith(Colour colour2) {
        red = (int) ((red + colour2.getRed()) * 0.5);
        green = (int) ((green + colour2.getGreen()) * 0.5);
        blue = (int) ((blue + colour2.getBlue()) * 0.5);
    }

    public Colour copy() {
        return new Colour(this.red, this.green, this.blue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return red == colour.red &&
                green == colour.green &&
                blue == colour.blue;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}

