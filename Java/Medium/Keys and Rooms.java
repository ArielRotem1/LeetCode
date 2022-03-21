class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);

        return canVisitAllRooms(0, rooms, hs) == n;
    }
    
    private int canVisitAllRooms(int currentRoom, List<List<Integer>> rooms, HashSet
        <Integer> hs){
        int count = 1;
        
        for(Integer room : rooms.get(currentRoom)){
            if(!hs.contains(room)){
                hs.add(room);
                count += canVisitAllRooms(room, rooms, hs);
            }
        }
        
        return count;
    }
}