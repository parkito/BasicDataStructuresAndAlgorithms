#include <iostream>
#include <map>

std::string isValid(std::string s) {
    std::map<char, int> map = std::map<char, int>();
    for (auto &ch:s) {
        map[ch]++;
    }
    if (map.size() <= 1) {
        return "YES";
    }
    auto first = map.begin();
    bool isDecrementUsed = false;
    for (auto it = std::next(first, 1); it != map.end(); ++it) {
        if (first->second != it->second) {
            if (!isDecrementUsed &&
                (std::abs(first->second - it->second) == 1 || (first->second == 1 || it->second == 1))
                    ) {
                isDecrementUsed = true;
            } else {
                return "NO";
            }
        }
    }
    return "YES";
}

int main() {
    std::cout << isValid("aabbcd") << std::endl; //no
    std::cout << isValid("aabbccddeefghi") << std::endl; //no
    std::cout << isValid("abcdefghhgfedecba") << std::endl; //yes
    std::cout << isValid("aaaabbcc") << std::endl; //no
    std::cout << isValid("aaabbbccce") << std::endl; //yes
}
