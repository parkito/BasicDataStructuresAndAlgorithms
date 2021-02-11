cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(algo VERSION 0.0.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_compile_options(-std=c++2a)

configure_file(Test/Tester/SourceDirLocation.h.in ${PROJECT_SOURCE_DIR}/Test/Tester/SourceDirLocation.h)

add_library(
        algo_lib
        SHARED
        Source/01_string_length/StringLength.cpp
        Source/02_hk_dynamic_array/DynamicArray.cpp
        Source/03_reverse_array/ReverseArray.cpp
        Source/04_left_shift/LeftShift.cpp
        Test/Cases/01_string_length/StringLengthTest.cpp
        Test/Cases/02_hk_dynamic_array/DynamicArrayTest.cpp
        Test/Tester/Tester.cpp
)
target_include_directories(
        algo_lib
        PUBLIC
        Source/00_global
        Source/01_string_length
        Source/02_hk_dynamic_array
        Test/Cases/01_string_length
        Test/Cases/02_hk_dynamic_array
        Test/Tester
)

add_executable(algo Test/TestRunner.cpp)
add_executable(03 Source/03_reverse_array/ReverseArray.cpp)
add_executable(04 Source/04_left_shift/LeftShift.cpp)

target_link_libraries(
        algo
        PRIVATE
        algo_lib
)

#cmake -H. -Bcmake-build-debug && cd cmake-build-debug && make all
