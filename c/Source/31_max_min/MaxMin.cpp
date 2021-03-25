#include <iostream>
#include <vector>

int maxMin(int k, std::vector<int> arr) {
    std::sort(arr.begin(), arr.end(), std::less<int>());
    int min = -1;
    for (int i = 0; i + k - 1 < arr.size(); ++i) {
        int unfair = arr[i + k - 1] - arr[i];
        if (unfair < min || min == -1) {
            min = unfair;
        }
    }

    return min;
}

int main() {
    std::cout << maxMin(2, {1, 4, 7, 2}) << std::endl;
    std::cout << maxMin(3, {100, 200, 300, 350, 400, 401, 402}) << std::endl;//2
}
