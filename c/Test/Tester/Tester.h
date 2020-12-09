#pragma once

#include <iostream>
#include <vector>
#include <memory>
#include <map>
#include "TestSuite.h"

#define SOURCE_DIR "${CMAKE_SOURCE_DIR}"

class Tester {
public:
    void run_tests();

protected:
    virtual std::string test_dir() = 0;

    virtual std::vector<std::string> test_case(std::vector<std::string> &) = 0;

private:
    bool is_test_file(const std::string &);

    bool is_in_file(const std::string &);

    int test_index(const std::string &);

    std::map<int, std::unique_ptr<TestSuite>> to_file_map(const std::string &);

    bool compare_out(const std::vector<std::string> &, const std::vector<std::string> &);

    void print_diff(const std::vector<std::string> &, const std::vector<std::string> &);

    std::vector<std::string> read_file(const std::string &);
};
