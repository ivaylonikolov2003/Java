import java.util.Arrays;

public class Card {
    private String face;
    private char suit;

    private static String[] ALL_FACES = new String[]{
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    private static String ALL_SUITS = "♠♥♦♣";

    public Card(String face, char suit) {
        this.setFace(face);
        this.setSuit(suit);
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        if (Arrays.stream(ALL_FACES).noneMatch(f -> f.equals(face)))
            throw new IllegalArgumentException("Invalid face: " + face);
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        if (ALL_SUITS.indexOf(suit) == -1)
            throw new IllegalArgumentException("Invalid suit: " + suit);
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.face + this.suit;
    }
}
