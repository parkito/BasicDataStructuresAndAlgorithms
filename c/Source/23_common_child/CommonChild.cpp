#include <iostream>
#include <unordered_set>
#include <vector>

int commonChild(std::string s1, std::string s2) {
    int matrix[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {
            if (i == 0 || j == 0) {
                matrix[i][j] = 0;
            } else if (s1[i - 1] == s2[j - 1]) {
                matrix[i][j] = matrix[i - 1][j - 1] + 1;
            } else {
                matrix[i][j] = std::max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
    }

    return matrix[s1.length()][s2.length()];
}

int main() {
    std::cout << commonChild("HARRY", "SALLY") << std::endl;//2
    std::cout << commonChild("SHINCHAN", "NOHARAAA") << std::endl;//3
    std::cout << commonChild("AA", "BB") << std::endl;//0
}
