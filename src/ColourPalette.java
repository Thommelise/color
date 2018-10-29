import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColourPalette {


    List<Colour> colours = new ArrayList<>();

    // adding colour to the list of Colours

    public void addColour(Colour colour) {
        colours.add(colour);
    }


    public Colour getColours(int index) {
        if (index < colours.size()) {

            return colours.get(index);

        }
        return null;
    }
    public List<Colour> getColor() {
        return colours;
    }

    public int numberOfColours() {

        return colours.size();
    }

    public int getNumberOfGreyColours() {
        int numberOfGrey = 0;
        for (int i = 0; i < colours.size(); i++) {
            if (colours.get(i).isGrey()) {

                numberOfGrey++;
            }
        }

        return numberOfGrey;
    }


    public void mixColours(int index, Colour colour2) {
        colours.get(index).mixWith(colour2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColourPalette that = (ColourPalette) o;
        return Objects.equals(colours, that.colours);
    }

    @Override
    public String toString() {
        return "ColourPalette{" +
                "colours=" + colours +
                '}';
    }
}