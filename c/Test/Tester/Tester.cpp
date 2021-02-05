#include "Tester.h"
#include <iomanip>
#include <fstream>

bool Tester::is_test_file(const std::string &str) {
    return str.find("test.") != std::string::npos;
}

bool Tester::is_in_file(const std::string &str) {
    return str.find(".in") != std::string::npos;
}

int Tester::test_index(const std::string &filename) {
    auto begin = filename.find_first_of('.') + 1;
    auto end = filename.find_last_of('.');
    return std::stoi(filename.substr(begin, end - begin));
}

std::map<int, std::unique_ptr<TestSuite>> Tester::to_file_map(const std::string &dir) {
    std::map<int, std::unique_ptr<TestSuite>> fileMap{};
    for (const auto &entry : std::filesystem::directory_iterator(dir)) {
        auto filename = entry.path().filename().string();
        if (is_test_file(filename)) {
            auto testIndex = test_index(filename);
            if (!fileMap.contains(testIndex)) {
                fileMap.insert(std::make_pair(testIndex, std::make_unique<TestSuite>(TestSuite{})));
            }
            if (is_in_file(filename)) {
                fileMap.find(testIndex)->second->in = entry;
            } else {
                fileMap.find(testIndex)->second->out = entry;
            }
        }
    }

    return fileMap;
}

bool Tester::compare_out(const std::vector<std::string> &expected, const std::vector<std::string> &actual) {
    if (expected.size() != actual.size()) {
        print_diff(expected, actual);
        return false;
    }

    for (int i = 0; i < expected.size(); ++i) {
        if (expected[i] != actual[i]) {
            print_diff(expected, actual);
            return false;
        }
    }

    return true;
}

void Tester::print_diff(const std::vector<std::string> &expected, const std::vector<std::string> &actual) {
    std::cout << " FAILED" << std::endl;
    auto maxIndex = std::max(expected.size(), actual.size());

    for (int i = 0; i < maxIndex; ++i) {
        std::string left;
        std::string right;
        std::string diffSign;
        if (i < expected.size()) {
            left = expected[i];
        }
        if (i < actual.size()) {
            right = actual[i];
        }
        if (left != right) {
            diffSign = "-> ";
        }
        std::cout << diffSign << std::left << std::setw(10) << left << std::setw(10) << right << std::endl;
    }
}

std::vector<std::string> Tester::read_file(const std::string &path) {
    std::fstream file(path);
    if (!file.is_open()) {
        throw std::runtime_error("Can't open file " + path);
    }
    std::vector<std::string> data;
    std::string line{};
    while (std::getline(file, line)) {
        data.push_back(line);
    }
    file.close();

    return data;
}

void Tester::run_tests() {
    std::cout << test_dir() << std::endl;
    const auto &testSuits = to_file_map(test_dir());
    for (auto const&[key, value]:testSuits) {
        std::vector<std::string> in = read_file(value->in);
        std::vector<std::string> out = read_file(value->out);
        auto testOut = test_case(in);
        std::cout << "Test suite # " << key;
        auto isEquals = compare_out(out, testOut);
        if (isEquals) {
            std::cout << " DONE" << std::endl;
        }
    }
}
