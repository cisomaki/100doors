package org.isomaki.onehundreddoors;

/**
 * Created by Chris Isomaki on 5/1/17.
 *
 *  *
 * http://rosettacode.org/wiki/100doors
 *
 * There are 100 doors in a row that are all initially closed.
 * You make 100 passes by the doors.
 * The first time through, visit every door and   toggle   the door   (if the door is closed,   open it;   if it is open,   close it).
 * The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.
 * The third time, visit every 3rd door   (door #3, #6, #9, ...), etc,   until you only visit the 100th door.
 */
public class Main {
    public static void main(String[] args) {
        boolean[] doors = initializeDoors(100);
        passThroughDoors(doors);
        showOpenDoors(doors);
    }

    private static void showOpenDoors(boolean[] doors) {
        StringBuilder output = new StringBuilder("Open doors: ");
        boolean firstFound = false;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i]) {
                if (firstFound) { // we only want to append a comma after we have added the first door
                    output.append(',');
                } else {
                    firstFound = true;
                }
                output.append((i + 1));
            }
        }

        System.out.println(output);
    }

    // Not very happy that this has a side effect smell but for such a simple example I suppose it's ok.
    private static void passThroughDoors(boolean[] doors) {
        // Not using perfect square optimization because...that kind of misses the point of the exercise, I think.
        for (int pass = 0; pass < doors.length; pass++) {
            System.out.println("Pass " + (pass+1));
            for (int door = pass; door < doors.length; door += (pass+1)) {
                System.out.println("  Setting door " + (door+1) + " to " + (!doors[door] ? "open" : "closed"));
                doors[door] = !doors[door];
            }
        }
    }


    private static boolean[] initializeDoors(int size) {
        boolean[] doors = new boolean[size];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = false;
        }
        return doors;
    }
}
