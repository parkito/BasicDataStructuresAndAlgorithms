#include <iostream>
#include <vector>

int getMinimumCost(int k, std::vector<int> c) {
    std::sort(c.begin(), c.end(), std::greater());
    int min = 0;
    for (int i = 0; i < c.size(); i++) {
        min += c[i] * (i / k + 1);
    }
    return min;
}

int main() {
    std::cout << getMinimumCost(3, {1, 3, 5, 7, 9});//29
}
