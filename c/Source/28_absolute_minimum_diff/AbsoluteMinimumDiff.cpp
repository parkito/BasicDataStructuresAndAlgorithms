#include <iostream>
#include <vector>

int minimumAbsoluteDifference(std::vector<int> arr) {
    std::sort(arr.begin(), arr.end(), [](const int &a, const int &b) {
        return a < b;
    });
    int min = arr[arr.size() - 1];
    for (int i = 0; i < arr.size() - 1; ++i) {
        int abs = std::abs(arr[i] - arr[i + 1]);
        if (abs < min) {
            min = abs;
        }
    }
    return min;
}

int main() {
    std::cout << minimumAbsoluteDifference({-2, 2, 4}) << std::endl;//2
}