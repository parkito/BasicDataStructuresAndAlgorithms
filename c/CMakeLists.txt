cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(algo VERSION 0.0.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

#set(CXXFLAGS ${CXXFLAGS} -std=c++2a)
add_compile_options(-std=c++2a)
message("Version ${CMAKE_CXX_COMPILER_VERSION}")

configure_file(Test/Tester/Cmake.h.in ${PROJECT_SOURCE_DIR}/Test/Tester/Cmake.h)

include_directories(Source/01_string_length
        Test/Cases
        Test/Tester
        )

add_executable(test1 Test/Tester/TestRunner.cpp)


