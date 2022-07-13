import java.util.*;
import java.io.*;

class Solution {
    
    HashMap<Long, Long> map = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }        
        return answer;
    }
    private long findRoom(long index) {
        if(!map.containsKey(index)) {
            map.put(index, index+1);
            return index;
        }

        long currentRoom = findRoom(map.get(index));
        map.put(index, currentRoom);
        return currentRoom;

    }
}