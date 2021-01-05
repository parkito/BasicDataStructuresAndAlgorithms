#include "StringLength.h"
#include "Tester.h"
#include "Cmake.h"

class StringLengthTest : public Tester {

protected:
    std::string test_dir() override {
        return cmake_dir() + "/Resource/01_string_length/";
    }

    static std::string to_string(const std::vector<std::string> &vec) {
        if (vec.empty()) {
            return "";
        } else {
            return vec[0];
        }
    }

    std::vector<std::string> test_case(std::vector<std::string> &vector) override {
        auto sl = StringLength();
        size_t result = sl.stringLength(to_string(vector));
        return {std::to_string(result)};
    }
};