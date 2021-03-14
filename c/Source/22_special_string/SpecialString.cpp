#include <iostream>
#include "../00_global/Global.h"


long combinations(const int num) {
    long com = 0;
    for (int i = 1; i <= num - 1; ++i) {
        com += i;
    }
    return com;
}

bool is_middle(const std::string &s, const int &from, const int &middle) {
    char toCompare = s[from];
//    std::cout << s.substr(from, (middle - from) * 2 + 1) << " ";
    for (int i = 1; i <= middle - from; ++i) {
        if (middle + i >= s.length() || s[middle - 1] != toCompare || s[middle - i] != s[middle + i]) {
            return false;
        }
    }
    return true;
}

long substrCount(int n, std::string s) {
    if (n <= 1) {
        return n;
    }
    long counter = 0;
    int groupFirst = 0;
    for (int i = 1; i < s.length(); ++i) {
        if (s[i] != s[groupFirst]) {
            int elements = i - groupFirst;
            if (is_middle(s, groupFirst, i)) {
                counter += 1 + 2 * combinations(elements);
                groupFirst = i;
            } else {
                if (elements > 1) {
                    counter += combinations(elements);
                    groupFirst = i - 1;
                } else {
                    groupFirst = i;
                }
            }
            i = groupFirst;
        } else if (i == s.length() - 1) {
            counter += combinations(s.length() - groupFirst);
        }
    }
    return counter + s.size();
}


int main() {
//    std::cout << is_middle("aassa", 0, 2);
    std::cout << substrCount(std::string("mnonopoo").size(), "mnonopoo") << std::endl; //12
    std::cout << substrCount(std::string("asasd").size(), "asasd") << std::endl; //7
    std::cout << substrCount(std::string("abcbaba").size(), "abcbaba") << std::endl; //10
    std::cout << substrCount(std::string("aaaa").size(), "aaaa") << std::endl; //10
    std::cout << substrCount(std::string("aaaa").size(),
                             global::file_to_string("/code/Source/22_special_string/test.txt")) << std::endl; //1272919
}

