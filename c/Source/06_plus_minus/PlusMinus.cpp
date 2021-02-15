#include <vector>
#include <iostream>

void plusMinus(std::vector<int> arr) {
    int negatives = 0;
    int zeros = 0;
    int positives = 0;
    for (auto &el:arr) {
        if (el < 0) {
            negatives++;
        } else if (el == 0) {
            zeros++;
        } else {
            positives++;
        }
    }
    printf("%.5f\n", (double) positives / arr.size());
    printf("%.5f\n", (double) negatives / arr.size());
    printf("%.5f\n", (double) zeros / arr.size());
}

int main() {
    plusMinus({-4, 3, -9, 0, 4, 1});
}
