#include <iostream>
#include <vector>
#include <unordered_map>

void whatFlavors(std::vector<int> cost, int money) {
    std::unordered_map<int, int> map;
    for (int i = 0; i < cost.size(); ++i) {
        int &currentPrice = cost[i];
        if (map.find(money - currentPrice) == map.end()) {
            map[currentPrice] = (i + 1);
        } else {
            std::cout << map[money - currentPrice] << " " << i + 1 << std::endl;
        }
    }
}

int main() {
    whatFlavors({2, 1, 3, 5, 6}, 5);
    whatFlavors({1, 4, 5, 3, 2}, 4);
    whatFlavors({2, 2, 4, 3}, 4);
}