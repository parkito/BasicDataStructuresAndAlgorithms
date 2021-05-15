#pragma once

#include <filesystem>

struct TestSuite {
    std::filesystem::path in;
    std::filesystem::path out;
};
