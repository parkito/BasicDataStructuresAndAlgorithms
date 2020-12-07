cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(cli VERSION 0.0.1)


set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

#set(CXXFLAGS ${CXXFLAGS} -std=c++2a)
add_compile_options(-std=c++2a)
message("Version ${CMAKE_CXX_COMPILER_VERSION}")


add_executable(main Source/Main.cpp)

