#include <vector>
class TwoSum{
public:
    /**
     * @brief 
     * 执行用时：268 ms, 在所有 C++ 提交中击败了34.22%的用户
     * 内存消耗：9.8 MB, 在所有 C++ 提交中击败了95.71%的用户
     * @param nums 
     * @param target 
     * @return vector<int> 
     */
    vector<int> twoSum_1(vector<int>& nums, int target) {
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        return {};
    }

    vector<int> twoSum_2(vector<int>& nums, int target) {
        unordered_map<int, int> hashtable;
        for (int i = 0; i < nums.size(); ++i) {
            auto it = hashtable.find(target - nums[i]);
            if (it != hashtable.end()) {
                return {it->second, i};
            }
            hashtable[nums[i]] = i;
        }
        return {};
    }
};
