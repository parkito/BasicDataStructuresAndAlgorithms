#include <iostream>
#include <vector>

int luckBalance(int k, std::vector<std::vector<int>> contests) {
    std::sort(contests.begin(), contests.end(), [](const std::vector<int> &vec1, const std::vector<int> &vec2) {
        return vec1[0] > vec2[0];
    });
    int wins = 0;
    for (auto &contest : contests) {
        if (contest[1] == 0) {
            wins += contest[0];
        } else if (contest[1] == 1 && k > 0) {
            wins += contest[0];
            k--;
        } else {
            wins -= contest[0];
        }
    }
    return wins;
}


int main() {
    std::cout << luckBalance(2, {{5, 1},
                                 {1, 1},
                                 {4, 0}}
    ) << std::endl; //10

    std::cout << luckBalance(3, {{5,  1},
                                 {2,  1},
                                 {1,  1},
                                 {8,  1},
                                 {10, 0},
                                 {5,  0}}
    ) << std::endl; //29
}
