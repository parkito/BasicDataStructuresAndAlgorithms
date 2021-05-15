#include <iostream>
#include "../00_global/Global.h"

long combinations(const int num) {
    long com = 0;
    for (int i = 1; i <= num - 1; ++i) {
        com += i;
    }
    return com;
}

long count_middle(const std::string &s, const int &middle) {
    long counter = 0;
    char ch;
    for (int i = 1; middle - i >= 0 && middle + i < s.length(); ++i) {
        if (i == 1) {
            ch = s[middle - i];
        }
        if (ch == s[middle - i] && ch == s[middle + i]) {
            counter++;
        } else {
            return counter;
        }
    }
    return counter;
}

long substrCount(int n, std::string s) {
    if (n <= 1) {
        return n;
    }
    long counter = 0;
    int groupFirst = 0;
    for (int i = 1; i < s.length(); ++i) {
        if (s[i] != s[groupFirst]) {
            counter += combinations(i - groupFirst);
            groupFirst = i;
        } else if (i == s.length() - 1) {
            counter += combinations(i - groupFirst + 1);
        }
    }

    for (int i = 1; i < s.length(); ++i) {
        if (s[i] != s[i - 1]) {
            counter += count_middle(s, i);
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
    std::cout << substrCount(std::string("aaaa").size(), "cccacc") << std::endl; //12
    std::cout << substrCount(std::string("aaaa").size(),
                             global::file_to_string("/code/Source/22_special_string/test.txt")) << std::endl; //1272919
}

