#include <iostream>
#include <unordered_set>
#include <vector>

int commonChild(std::string s1, std::string s2) {
    int line1[s1.length() + 1];
    int line2[s1.length() + 1];
    line2[0] = 0;
    for (int i = 0; i <= s1.length(); ++i) {
        line1[i] = 0;
    }
    for (int i = 1; i <= s1.length(); i++) {
        if (i != 1) {
            for (int j = 0; j <= s1.length(); ++j) {
                line1[j] = line2[j];
            }
        }
        for (int j = 1; j <= s1.length(); j++) {
            if (s1[j - 1] == s2[i - 1]) {
                line2[j] = line1[j - 1] + 1;
            } else {
                line2[j] = std::max(line1[j], line2[j - 1]);
            }
        }
    }

    return line2[s2.length()];
}

int main() {
    std::cout << commonChild("HARRY", "SALLY") << std::endl;//2
    std::cout << commonChild("OUDFRMYMAW", "AWHYFCCMQX") << std::endl;//2
    std::cout << commonChild("SHINCHAN", "NOHARAAA") << std::endl;//3
    std::cout << commonChild("AA", "BB") << std::endl;//0
}
