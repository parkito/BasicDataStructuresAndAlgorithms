#include <iostream>
#include <vector>
#include <set>

int sockMerchant(int n, std::vector<int> arr) {
    std::set<int> set = std::set<int>{};
    int pairs = 0;
    for (auto &el:arr) {
        if (set.find(el) != set.end()) {
            pairs++;
            set.erase(el);
        } else {
            set.insert(el);
        }
    }
    return pairs;
}

int main() {
    sockMerchant(9, {10, 20, 20, 10, 10, 30, 50, 10, 20});
}
