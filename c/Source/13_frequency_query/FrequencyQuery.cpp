#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>

std::vector<int> freqQuery(std::vector<std::vector<int>> queries) {
    std::unordered_map<int, int> map = std::unordered_map<int, int>();
    int resultSize = 0;
    for (auto &vec:queries) {
        if (vec[0] == 3) {
            resultSize++;
        }
    }
    int rezIndex = 0;
    std::vector<int> result(resultSize);
    for (auto &vec:queries) {
        auto command = vec[0];
        auto el = vec[1];
        if (command == 1) {
            map[el]++;
        } else if (command == 2) {
            auto foundIter = map.find(el);
            if (foundIter != map.end()) {
                if (foundIter->second > 0) {
                    foundIter->second--;
                }
            }
        } else if (command == 3) {
            bool isAdded = false;
            for (auto &it : map) {
                if (it.second == el) {
                    result[rezIndex++] = 1;
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                result[rezIndex++] = 0;
            }
        }
    }
    return result;
}

int main() {
    freqQuery({
                      {1, 89},
                      {3, 15},
                      {1, 12},
                      {1, 47},
                      {1, 23},
                      {1, 66},
                      {2, 28},
                      {3, 2},
                      {2, 15},
                      {1, 16},
                      {3, 16},
                      {1, 17},
                      {1, 73},
                      {2, 44},
                      {3, 14},
                      {2, 30},
                      {2, 38},
                      {2, 4},
                      {1, 4},
                      {2, 35},
                      {1, 28},
                      {1, 9},
                      {1, 68},
                      {3, 1},
                      {3, 33},
                      {3, 5}
              });
}
