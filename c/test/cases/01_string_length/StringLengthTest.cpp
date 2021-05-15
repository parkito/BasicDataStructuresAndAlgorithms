#include <StringLength.h>
#include "StringLengthTest.h"

std::string StringLengthTest::test_dir() {
    return std::string(SOURCE_DIR_LOCATION) + "/Resource/01_string_length/";
}

std::vector <std::string> StringLengthTest::test_case(std::vector <std::string> &vector) {
    auto sl = StringLength();
    size_t result = sl.stringLength(to_string(vector));
    return {
            std::to_string(result)
    };
}

std::string StringLengthTest::to_string(const std::vector <std::string> &vec) {
    if (vec.empty()) {
        return "";
    } else {
        return vec[0];
    }
}
