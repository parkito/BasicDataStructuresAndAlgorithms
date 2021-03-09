#include <iostream>

int alternatingCharacters(std::string s) {
    if (s.empty() || s.size() == 1) {
        return 0;
    }
    int counter = 0;
    char toCompare = s[0];
    for (int i = 1; i < s.size(); ++i) {
        if (toCompare == s[i]) {
            counter++;
        } else {
            toCompare = s[i];
        }
    }
    return counter;
}

int main() {
    std::cout << alternatingCharacters("AAAA") << std::endl;//3
    std::cout << alternatingCharacters("BBBBB") << std::endl; //4
    std::cout << alternatingCharacters("ABABABAB") << std::endl; //0
    std::cout << alternatingCharacters("BABABA") << std::endl; //0
    std::cout << alternatingCharacters("AAABBB") << std::endl; //0
}
