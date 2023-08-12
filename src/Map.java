public class Map {

    /** A double array of Room objects that stores the location. */
    private Room[][] map;

    /** A double array of Room objects that stores the location. */
    private boolean[][] doors;

    /** Current X coordinate in the map. */
    private int x;

    /** Current Y coordinate in the map. */
    private int y;

    /** Previous X coordinate in the map. */
    private int x_prev;

    /** Previous Y coordinate in the map. */
    private int y_prev;

    /**
     * @param x_Size
     *            This map horizontal size.
     * @param y_Size
     *            This map vertical size.
     */
    public Map(int x_Size, int y_Size) {
        map = new Room[y_Size * 2 + 1][x_Size * 2 + 1];
        doors = new boolean[y_Size * 2 + 1][x_Size * 2 + 1];
        for (int i = 0; i < map.length; i++ ) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = null;
                doors[i][j] = false;
            }
        }
        x_prev = 1;
        y_prev = 1;
    }

    /** Change the room the player is located at to nextRoom. */
    public void goNextRoom(Room nextRoom) {
        x_prev = x;
        y_prev = y;
        x = nextRoom.getX() * 2 + 1;
        y = nextRoom.getY() * 2 + 1;
    }

    /** Put the given into the map. */
    public void insertRoom(Room room) { map[room.getY() * 2 + 1][room.getX() * 2 + 1] = room; }

    /** Force set the Room that the player is in to (x, y) */
    public void setCurrentRoom(int x, int y) {
        this.x = x * 2 + 1;
        this.y = y * 2 + 1;
    }

    /** Set the door between the given two rooms open (true) or close (false). Note the two rooms need to be adjacent to each other.
     * Default: The doors of every room starts off as closed.
     */
    public void setDoor(Room room1, Room room2, boolean doorIsOpen) {
        int x1 = room1.getX() * 2 + 1;
        int y1 = room1.getY() * 2 + 1;
        int x2 = room2.getX() * 2 + 1;
        int y2 = room2.getY() * 2 + 1;
        doors[Math.abs(y2 + y1) / 2][Math.abs(x2 + x1) / 2] = doorIsOpen;
    }

    /**
     * Returns the room of the given direction (up, down, left, right) from the current room.
     * If no room exists, return null.
     */
    public Room getNeighbor(String direction) {
        if (direction.equals("up")) {
            if (doors[y - 1][x]) {
                return map[y - 2][x];
            }
        } else if (direction.equals("down")) {
            if (doors[y + 1][x]) {
                return map[y + 2][x];
            }
        } else if (direction.equals("left")) {
            if (doors[y][x - 1]) {
                return map[y][x - 2];
            }
        } else if (direction.equals("right")) {
            if (doors[y][x + 1]) {
                return map[y][x + 2];
            }
        } else { return null; }

        return null;
    }


    /**  Return the current room where the player is located at */
    public Room getCurrentRoom() {
        return map[y][x];
    }

    /** Return previous room. */
    public Room getPreviousRoom() { return map[y_prev][x_prev]; }
}
