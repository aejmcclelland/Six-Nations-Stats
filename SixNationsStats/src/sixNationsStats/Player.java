package sixNationsStats;
public class Player {
    private String country;
    private String position;
    private String name;
    private int games;
    private int tackles;
    private int dominantTackles;
    private int tackleBreaks;
    private int metresWithBall;
    private int tries;

    public Player(String country, String position, String name, int games, int tackles, int dominantTackles, int tackleBreaks, int metresWithBall, int tries) {
        this.country = country;
        this.position = position;
        this.name = name;
        this.games = games;
        this.tackles = tackles;
        this.dominantTackles = dominantTackles;
        this.tackleBreaks = tackleBreaks;
        this.metresWithBall = metresWithBall;
        this.tries = tries;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return 
                "First name: " + name.split(" ")[1] + "\n" +
                "Surname: " + name.split(" ")[0] + "\n" +
                "Country: " + country + "\n" +
                "Position: " + position + "\n" +
                "Total Games: " + games + "\n" +
                "Tackles: " + tackles + "\n" +
                "Dominant Tackles: " + dominantTackles + "\n" +
                "Tackle Breaks: " + tackleBreaks + "\n" +
                "Metres with Ball: " + metresWithBall + "\n" +
                "Tries: " + tries + "\n\n";
    }
}
