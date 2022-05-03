class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> answer;
        
        int find_target = find(nums, target, 1);
        
        if(find_target == -1) {
            answer.push_back(-1);
            answer.push_back(-1);
        } else {
            int find_target_end = find(nums, target, 2);
            answer.push_back(find_target);
            answer.push_back(find_target_end);
        }
                
        return answer;
    }
    
    int find(vector<int>& nums, int target, int turn) {
        
        int start = 0;
        int end = nums.size() - 1;
        
        while(start <= end) {
            
            int mid = (start + end) / 2;
            
            if(nums[mid] == target) {
                
                if(turn == 1) {
                    
                    if(mid == start || nums[mid - 1] != target)
                        return mid;
                    else {
                        end = mid - 1;
                    }                    
                } else {
                    
                    if(mid == end || nums[mid + 1] != target)
                        return mid;
                    else
                        start = mid + 1;
                    
                }
                
                
                
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
                
            }
            
                        
        }
        return -1;
    }
    
};