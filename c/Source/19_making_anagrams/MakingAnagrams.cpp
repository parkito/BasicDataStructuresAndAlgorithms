#include <iostream>
#include <map>

std::map<char, int> to_map(std::string &str) {
    std::map<char, int> map = std::map<char, int>();
    for (auto &ch:str) {
        map[ch]++;
    }
    return map;
}

int count_deletes(std::map<char, int> &fis, std::map<char, int> &sec) {
    int counter = 0;
    for (auto &pair:sec) {
        auto content = fis[pair.first];
        if (content != pair.second) {
            counter += std::abs(content - pair.second);
        }
    }
    return counter;
}

int makeAnagram(std::string a, std::string b) {
    auto fs = to_map(a);
    auto sec = to_map(b);
    return std::max(count_deletes(fs, sec), count_deletes(sec, fs));
}

int main() {
    std::cout << makeAnagram("cde", "abc");
}
