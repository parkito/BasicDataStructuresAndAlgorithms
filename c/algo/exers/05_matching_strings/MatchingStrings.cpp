#include "iostream"
#include "vector"
#include "map"
#include "../00_global/Global.h"

// Complete the matchingStrings function below.
std::vector<int> matchingStrings(std::vector<std::string> strings, std::vector<std::string> queries) {
    std::map<std::string, int> stringMap{};
    for (auto &str:strings) {
        if (stringMap.find(str) == stringMap.end()) {
            stringMap[str] = 1;
        } else {
            stringMap[str]++;
        }
    }
    std::vector<int> result{};

    for (auto &query:queries) {
        if (stringMap.find(query) == stringMap.end()) {
            result.push_back(0);
        } else {
            result.push_back(stringMap[query]);
        }
    }

    return result;
}

int main() {
    global::print(matchingStrings({"aba", "baba", "aba", "xzxb"}, {"aba", "xzxb", "ab"}));
}
