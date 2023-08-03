package dev.lpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, Location> gameMap = new HashMap<>();

        Location road = new Location(
                """
                 You are in the middle of a road. There is no one around.
                      From here, you can see:
                      * A forest in the North (N)
                      * A valley in the South (S)
                      * A house in the East (E)
                      * A hill in the West (W)
                 Select the direction you want to move, or Q to quit""");
        road.addNextMove("N", "Forest");
        road.addNextMove("S", "Valley");
        road.addNextMove("E", "House");
        road.addNextMove("W", "Hill");
        gameMap.put("Road", road);
        // Road 1;

        Location blackForest = new Location(
                """
                 You have arrived in a deep ancient forest shadowed realm, where moonlight dares not touch,
                 whispered secrets linger, woven by elusive elves in the haunting tapestry of the dark.
                      From here, you can see:
                      * The road that got you here (S);
                      * More forest, more darker, more colder, more quiet (N)
                      * Same (E)
                      * More (W)
                 Select the direction you want to move, or Q to quit""");

        blackForest.addNextMove("N", "Dead");
        blackForest.addNextMove("S", "Road");
        blackForest.addNextMove("E", "Dead");
        blackForest.addNextMove("W", "Dead");
        gameMap.put("Forest", blackForest);
        // Black Forest;

        Location deadBlackForest = new Location(
                """
                 Why did you even wanted to go deeper? Now you're dead, are you happy?
                 Just press Q to start over, damn!""");
        gameMap.put("Dead", deadBlackForest);
        // Dead in the Black Forest;

        Location hill = new Location(
                """
                 In the idyllic small village of hobbits perched upon a gentle hill,
                 quaint thatched-roof cottages huddled together,
                 emanating a sense of community and contentment as laughter and the
                 aroma of freshly baked pies filled the air.
                      Choose your next road:
                      * The road that got you here (E);
                      * Strange fire in the woods (N)
                 Select the direction you want to move, or Q to quit""");
        hill.addNextMove("E", "Road");
        hill.addNextMove("N", "Fire");
        gameMap.put("Hill", hill);
        // Hill;

        Location fire = new Location(
                """
                 It's Sauron, and it's giving you the finger from the fires of HELL. Go back!
                      Choose your path:
                      * Go back the in village like a pussy (S);
                 Select the direction you want to move, or Q to quit""");
        fire.addNextMove("S", "Dead2");
        gameMap.put("Fire", fire);
        // Sauron's Fire;

        Location deadByPussyness = new Location(
                """
                 There is no village you fucking pussy, they are all burning alive, screaming in agony.
                 Was that hard for you to just stay and fight??
                 I mean, you just had to throw that stupid ring in the volcano, you don't need any karate moves.
                 Press Q you wuss!""");
        gameMap.put("Dead2", deadByPussyness);
        // Dead by being a pussy;

        Location valley = new Location(
                """
                 As they descended into the verdant valley, its emerald slopes embraced by misty mountains,
                 the Fellowship (I mean, just you, because you have no friends) beheld a haven untouched by the terrors of the outside world,
                 where crystal-clear streams meandered amidst blooming wildflowers,
                 and a sense of peace settled upon their weary hearts,
                 offering respite from the perils of their perilous journey.
                      Choose your path:
                      * Go back from where you came (N)
                      * It's a trap, don't go there! (S)
                      * Naked female persons in your area (Q)
                 Select the direction you want to move, or Q to quit""");
        valley.addNextMove("N", "Road");
        valley.addNextMove("S", "Trap");
        gameMap.put("Valley", valley);
        // Valley;

        Location trap = new Location(
                """
                 Just kidding! Life if already hard enough. Take care!
                 But here is a "yo mama" joke: Your momma is so ugly she made One Direction go another direction.
                      Choose your destiny:
                      * Go back from where you came (S)
                 Select the direction you want to move, or Q to quit""");
        trap.addNextMove("S", "Valley");
        gameMap.put("Trap", trap);
        // Trap;

        Location house = new Location(
                """
                 Nothing to see here, It's Hugh Laurie from House M.D.
                      What now?
                      * Go back from where you came (W)
                 Select the direction you want to move, or Q to quit""");
        house.addNextMove("W", "Road");
        gameMap.put("House", house);
        // House;

        String currentLocation = "Road";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Location current = gameMap.get(currentLocation);
            System.out.println(current);

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Quitting the game...");
                break;
            }

            String nextLocation = current.getNextLocation(input);

            if (nextLocation == null) {
                System.out.println("Invalid direction. Try again.");
            } else {
                currentLocation = nextLocation;
            }
        }
    }
}
