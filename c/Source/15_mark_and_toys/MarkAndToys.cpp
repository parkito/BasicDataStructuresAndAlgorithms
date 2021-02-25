#include <iostream>
#include <vector>

int maximumToys(std::vector<int> prices, int k) {
    std::sort(prices.begin(), prices.end());
    int currentSum = 0;
    int toys = 0;
    for (int &price : prices) {
        currentSum += price;
        if (currentSum <= k) {
            toys++;
        } else {
            return toys;
        }
    }
    return toys;
}

int main() {
    std::cout << maximumToys({1, 12, 5, 111, 200, 1000, 10}, 50);//4
};

