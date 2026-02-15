package de.illilli.kulturpfade.services;

/**
 * Extrahiert id, nr und location aus der einem String
 */
public class IdParser {

    private String location;
    private int id;
    private int nr;
    private String point;

    public IdParser(String input) {
        String[] parts = input.split("-");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Ungültige ID: Erwartet Format 'location-pID-nr'");
        }

        this.location = parts[0];

        try {
            this.id = Integer.parseInt(parts[1].substring(1)); // ohne 'p'
            this.nr = Integer.parseInt(parts[2]);
            this.point = parts[1].substring(0, 1); // 'p', 'o', 'u'
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ungültige ID: Zahlen konnten nicht gelesen werden.");
        }
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public int getNr() {
        return nr;
    }

    public String getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Location: %s, ID: %d, Nr: %d".formatted(location, id, nr);
    }

    public static void main(String[] args) {
        String[] testIds = {
                "frankenberg-p27-27",
                "frankenberg-p06-6",
                "stadt-p003-3"
        };

        for (String idString : testIds) {
            try {
                IdParser parser = new IdParser(idString);
                System.out.println(parser);
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler bei '" + idString + "': " + e.getMessage());
            }
        }
    }
}