cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(ds_and_algo_project VERSION 0.0.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_compile_options(-std=c++2a)

add_library(
        ds_lib
        STATIC
        bag/Bag.cpp
)

target_include_directories(
        ds_lib
        PUBLIC
        ${PROJECT_SOURCE_DIR}/bag
)

add_executable(bag src/BagTest.cpp)

target_link_libraries(
        bag
        PRIVATE
        ds_lib
)

#cmake -H. -Bcmake-build-debug && cd cmake-build-debug && make all
