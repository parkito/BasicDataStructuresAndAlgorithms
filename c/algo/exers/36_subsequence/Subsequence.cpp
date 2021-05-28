#include <iostream>
#include <vector>

bool isSubsequence(std::vector<int> main, std::vector<int> sub) {
    int im = 0;
    int is = 0;
    while (is < sub.size() && im < main.size()) {
        if (main[im] == sub[is]) {
            is++;
        }
        im++;
    }
    return is == sub.size();
}

int main() {
    std::cout << isSubsequence({5, 1, 22, 25, 6, -1, 8, 10}, {1, 6, -1, 10}) << std::endl; //1
    std::cout << isSubsequence({1, 2, 4, 3, 3}, {1, 2, 3, 4}) << std::endl; //0
    std::cout << isSubsequence({-1, -1, 4, 3, 3, 4}, {-1, -1, 3, 4}) << std::endl; //1
}