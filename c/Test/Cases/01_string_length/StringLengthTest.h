#include "StringLength.h"
#include "Tester.h"
#include "Cmake.h"

class StringLengthTest : public Tester {
protected:
    std::string test_dir() override;

    std::vector<std::string> test_case(std::vector<std::string> &vector) override;

private:
    static std::string to_string(const std::vector<std::string> &vec);
};