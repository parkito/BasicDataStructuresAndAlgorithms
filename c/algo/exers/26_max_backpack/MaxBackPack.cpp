#include <cassert>
#include <cstdint>
#include <iostream>
#include <vector>
#include<algorithm>
#include <iomanip>

struct Item final {
    int weight;
    int value;
};

double get_max_knapsack_value(int capacity, std::vector<Item> items) {
    std::sort(items.begin(), items.end(), [](const Item &s1, const Item &s2) {
        return static_cast <double>(s1.value) / s1.weight > static_cast <double>(s2.value) / s2.weight;
    });
    double value = 0.0;
    for (auto &item:items) {
        if (capacity >= item.weight) {
            capacity -= item.weight;
            value += item.value;
        } else {
            value += capacity * (static_cast <double>(item.value) / static_cast <double>(item.weight));
            break;
        }
    }

    return value;
}

int main(void) {
    int number_of_items;
    int knapsack_capacity;
    std::cin >> number_of_items >> knapsack_capacity;
    std::vector<Item> items(number_of_items);
    for (int i = 0; i < number_of_items; i++) {
        std::cin >> items[i].value >> items[i].weight;
    }

    double max_knapsack_value = get_max_knapsack_value(knapsack_capacity, std::move(items));

//    std::cout.precision(10);
    std::cout << std::fixed << std::setprecision(3) << max_knapsack_value << std::endl;
    return 0;
}