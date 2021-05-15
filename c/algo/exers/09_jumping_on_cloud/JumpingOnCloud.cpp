#include <iostream>
#include <vector>

int jumpingOnClouds(std::vector<int> c) {
    int jumps = 0;
    for (int i = 0; i < c.size() - 1;) {
        if (i <= c.size() - 2 && c[i + 2] == 0) {
            i += 2;
        } else {
            i++;
        }
        jumps++;
    }
    return jumps;
}

int main() {
    std::cout << jumpingOnClouds({0, 0, 1, 0, 0, 1, 0}) << std::endl;
    std::cout << jumpingOnClouds({0, 1, 0, 0, 0, 1, 0}) << std::endl;
}
