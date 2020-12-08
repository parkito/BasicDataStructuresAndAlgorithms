#include "StringLength.cpp"
#include "Tester.cpp"
#include "Cmake.h"

class StringLengthTest : public Tester {

protected:
    std::string test_dir() override {
        return cmake_dir() + "/Resource/01_string_length/";
    }

    std::vector<std::string> test_case(std::vector<std::string> &vector) override {
        size_t result = StringLength().stringLength(vector[0]);
        return {std::to_string(result)};
    }
};