#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>

std::vector<int> freqQuery(std::vector<std::vector<int>> queries) {
    std::unordered_map<int, int> map = std::unordered_map<int, int>();
    std::unordered_map<int, int> occurMap = std::unordered_map<int, int>();
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
            auto occurrence = map[el]++;
            occurMap[occurrence + 1]++;
            if (occurrence > 0) {
                occurMap[occurrence]--;
            }
        } else if (command == 2) {
            auto foundIter = map.find(el);
            if (foundIter != map.end()) {
                if (foundIter->second > 0) {
                    auto occurrence = --foundIter->second;
                    occurMap[occurrence + 1]--;
                    if (occurrence > 0) {
                        occurMap[occurrence]++;
                    }
                }
            }

        } else if (command == 3) {
            result[rezIndex++] = occurMap[el] > 0 ? 1 : 0;
        }
    }

    return result;
}

int main() {
    freqQuery({
                      {1, 5},
                      {1, 6},
                      {3, 2},
                      {1, 10},
                      {1, 10},
                      {2, 5},
                      {3, 2},
              });
}
