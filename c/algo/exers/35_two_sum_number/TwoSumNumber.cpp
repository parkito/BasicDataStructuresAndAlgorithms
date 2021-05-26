#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>

//space O(n)
//time O(n)
bool sumUp(const std::vector<int> &vec, int num) {
    std::unordered_map<int, bool> map{};
    for (const auto &item : vec) {
        if (map.contains(item)) {
            map[item] = true;
        } else {
            map[item] = false;
        }
    }

    for (const auto &item : map) {
        auto toFind = num - item.first;
        auto found = map.find(toFind);
        if (found != map.end()) {
            if (found->first == item.first) {
                return found->second;
            }
            return true;
        }
    }
    return false;
}

//space no additional
//time O*log(n)
bool sumUpLog(std::vector<int> vec, int num) {
    std::sort(vec.begin(), vec.end());
    std::size_t left = 0;
    std::size_t right = vec.size() - 1;

    while (left != right) {
        int currentSum = vec[left] + vec[right];
        if (currentSum == num) {
            return true;
        }
        if (currentSum > num) {
            right--;
        } else {
            left++;
        }
    }

    return false;
}

int main() {
    std::cout << sumUp({5 , 5}, 10) << std::endl; //1
    std::cout << sumUp({11, -1}, 10) << std::endl; //1
    std::cout << sumUp({-1, -11}, 10) << std::endl; //0
    std::cout << sumUp({-1, 11}, 10) << std::endl; //1
    std::cout << sumUp({1, -11}, -10) << std::endl; //1
    std::cout << sumUp({3, 5, -4, 8, 11, 1, -1, 6}, 10) << std::endl; //1
    std::cout << sumUp({3, 5, -4, 8, 11, 1, -1, 6}, 15) << std::endl; //0
    std::cout << sumUp({3, 5, -4, 8, 11, 0, 6}, 10) << std::endl; //0

    std::cout << std::endl;

    std::cout << sumUpLog({5 , 5}, 10) << std::endl; //1
    std::cout << sumUpLog({11, -1}, 10) << std::endl; //1
    std::cout << sumUpLog({-1, -11}, 10) << std::endl; //0
    std::cout << sumUpLog({-1, 11}, 10) << std::endl; //1
    std::cout << sumUpLog({1, -11}, -10) << std::endl; //1
    std::cout << sumUpLog({3, 5, -4, 8, 11, 1, -1, 6}, 10) << std::endl; //1
    std::cout << sumUpLog({3, 5, -4, 8, 11, 1, -1, 6}, 15) << std::endl; //0
    std::cout << sumUpLog({3, 5, -4, 8, 11, 0, 6}, 10) << std::endl; //0
}
