cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(algo VERSION 0.0.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_compile_options(-std=c++2a)

configure_file(Test/Tester/Cmake.h.in ${PROJECT_SOURCE_DIR}/Test/Tester/Cmake.h)

include_directories(
        Source/01_string_length
        Source/02_hk_dynamic_array
        Test/Cases
        Test/Tester
)

add_executable(test1 Test/TestRunner.cpp)


