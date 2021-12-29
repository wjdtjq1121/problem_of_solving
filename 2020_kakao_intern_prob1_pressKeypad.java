import java.util.*;
import java.io.*;

class Solution {
    int numPad[][] = {
        {3, 1}, //0
        {0, 0}, //1
        {0, 1}, //2
        {0, 2},
        {1, 0},
        {1, 1},
        {1, 2},
        {2, 0},
        {2, 1},
        {2, 2}
    };
    String hand;
    int left[] = {3, 0};
    int right[] = {3, 2};
    public String solution(int[] numbers, String hand) {
        String answer = "";
        this.hand = hand.equals("left") ? "L" : "R";
        
        for(int num: numbers) {
            String point = pushNumber(num);
            answer += point;
            
            if(point == "L") {
                left = numPad[num];
                continue;
            }
            if(point == "R") {
                right = numPad[num];
                continue;
            }
            
        }

        return answer;
    }
    public String pushNumber(int idx) {
        if(idx == 1 || idx == 4 || idx == 7)
            return "L";
        if(idx == 3 || idx == 6 || idx == 9)
            return "R";
        
        if(getDist(left, idx) < getDist(right, idx)) {
            left = numPad[idx];
            return "L";
        }
        if(getDist(left, idx) > getDist(right, idx)) {
            right = numPad[idx];
            return "R";
        }
        return hand;
    }
    public int getDist(int pos[], int idx) {
        return Math.abs(pos[0] - numPad[idx][0]) + Math.abs(pos[1] - numPad[idx][1]);
    }
}