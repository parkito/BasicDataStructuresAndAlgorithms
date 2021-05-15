#include <iostream>
#include <vector>
#include <unordered_map>

void checkMagazine(std::vector<std::string> magazine, std::vector<std::string> note) {
    std::unordered_map<std::string, int> map = std::unordered_map<std::string, int>();
    for (auto &line:magazine) {
        if (map.find(line) == map.end()) {
            map.insert(std::make_pair(line, 1));
        } else {
            ++map[line];
        }
    }
    for (auto &line:note) {
        if (map.find(line) == map.end() || map[line]-- < 1) {
            std::cout << "No" << std::endl;
            return;
        }
    }
    std::cout << "Yes" << std::endl;
}

int main() {
    checkMagazine({"two", "times", "three", "is", "not", "four"},
                  {"two", "times", "two", "is", "four"}
    );//no
    checkMagazine({"give", "me", "one", "grand", "today", "night"},
                  {"give", "one", "grand", "today"}
    );//yes
}
