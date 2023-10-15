package sixNationsStats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sixNationsStats {

    public static void main(String[] args) {
        Map<String, List<Player>> playersByCountry = readAndGroupPlayersByCountry();

        if (playersByCountry.isEmpty()) {
            System.out.println("No players found.");
        } else {
            System.out.println("Players by country:");
            for (Map.Entry<String, List<Player>> entry : playersByCountry.entrySet()) {
                String country = entry.getKey();
                List<Player> players = entry.getValue();
                System.out.println("Country: " + country);
                for (Player player : players) {
                    System.out.println(player);
                }
            }
        }
    }

    public static Map<String, List<Player>> readAndGroupPlayersByCountry() {
        Map<String, List<Player>> playersByCountry = new HashMap<>();

        try {
            File file = new File("rugby_player_stats.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String header = br.readLine(); // Read and discard the header line

            String playerData;
            while ((playerData = br.readLine()) != null) {
                Player player = parsePlayer(playerData);
                String country = player.getCountry();

                // Check if the country key exists in the map, and add the player to the list
                if (!playersByCountry.containsKey(country)) {
                    playersByCountry.put(country, new ArrayList<>());
                }
                playersByCountry.get(country).add(player);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return playersByCountry;
    }

    public static Player parsePlayer(String playerData) {
        String[] playerAttributes = playerData.split(",");
        String country = playerAttributes[0].trim();
        String position = playerAttributes[1].trim();
        String name = playerAttributes[2].trim();
        int games = parseIntWithDefault(playerAttributes[3].trim(), 0);
        int tackles = parseIntWithDefault(playerAttributes[4].trim(), 0);
        int dominantTackles = parseIntWithDefault(playerAttributes[5].trim(), 0);
        int tackleBreaks = parseIntWithDefault(playerAttributes[6].trim(), 0);
        int metresWithBall = parseIntWithDefault(playerAttributes[7].trim(), 0);
        int tries = parseIntWithDefault(playerAttributes[8].trim(), 0);

        return new Player(country, position, name, games, tackles, dominantTackles, tackleBreaks, metresWithBall, tries);
    }

    private static int parseIntWithDefault(String value, int defaultValue) {
        if (value.isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }


    public static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Handle where the value is empty or not a number
            return 0; // default value
        }
    }

}
