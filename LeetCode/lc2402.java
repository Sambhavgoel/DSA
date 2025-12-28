import java.util.*;

public class lc2402 {

    public static int mostBooked(int n, int[][] meetings) {
        // sort by starting time of meetings
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Each room is used 0 times in the beginning
        int[] roomsUsedCount = new int[n];

        var usedRooms = new PriorityQueue<long[]>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var unusedRooms = new PriorityQueue<Integer>();

        for (int room = 0; room < n; room++) {
            unusedRooms.add(room); // All rooms are unused in the beginning
        }

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];

            // First see, by this time, which rooms can be empty now
            // And move them to unusedRooms
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.add(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.add(new long[] { end, room });
                roomsUsedCount[room]++;
            } else { // We don't have any room available now. Pick the earliest end room
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.poll()[0];
                usedRooms.add(new long[] { endTime + (end - start), room });
                roomsUsedCount[room]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsUsedCount[room] > maxUse) {
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }

    public static void main(String[] args) {

        // Number of roomslc1352
        int n = 2;

        // Meetings: {start, end}
        int[][] meetings = {
                { 0, 10 },
                { 1, 5 },
                { 2, 7 },
                { 3, 4 }
        };

        int result = mostBooked(n, meetings);

        System.out.println("Most booked room is: " + result);
    }
}
