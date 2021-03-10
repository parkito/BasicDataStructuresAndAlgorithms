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
        Source/05_matching_strings/MatchingStrings.cpp
        Source/06_plus_minus/PlusMinus.cpp
        Source/07_sales_by_match/SalesByMatch.cpp
        Source/08_counting_valley/CountingValley.cpp
        Source/09_jumping_on_cloud/JumpingOnCloud.cpp
        Source/10_repeated_string/RepeatedString.cpp
        Source/11_new_year_chaos/NewYearChaos.cpp
        Source/12_ransom_note/RansomNote.cpp
        Source/13_frequency_query/FrequencyQuery.cpp
        Source/14_bubble_sort/BubbleSort.cpp
        Source/15_mark_and_toys/MarkAndToys.cpp
        Source/16_comparator/Comparator.cpp
        Source/17_fraudulent_activity_notifications/FraudulentActivityNotifications.cpp
        Source/18_merge_sort_counting/MergeSortCounting.cpp
        Ds/Sorting/Selection.cpp
        Ds/Sorting/Insertion.cpp
        Ds/Sorting/Shell.cpp
        Ds/Sorting/Merge.cpp
        Ds/Sorting/Quick.cpp
        Source/19_making_anagrams/MakingAnagrams.cpp
        Source/20_alternating_characters/AlternatingCharacters.cpp
        Source/21_valid_string/ValidString.cpp
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
add_executable(05 Source/05_matching_strings/MatchingStrings.cpp)
add_executable(06 Source/06_plus_minus/PlusMinus.cpp)
add_executable(07 Source/07_sales_by_match/SalesByMatch.cpp)
add_executable(08 Source/08_counting_valley/CountingValley.cpp)
add_executable(09 Source/09_jumping_on_cloud/JumpingOnCloud.cpp)
add_executable(10 Source/10_repeated_string/RepeatedString.cpp)
add_executable(11 Source/11_new_year_chaos/NewYearChaos.cpp)
add_executable(12 Source/12_ransom_note/RansomNote.cpp)
add_executable(13 Source/13_frequency_query/FrequencyQuery.cpp)
add_executable(14 Source/14_bubble_sort/BubbleSort.cpp)
add_executable(15 Source/15_mark_and_toys/MarkAndToys.cpp)
add_executable(16 Source/16_comparator/Comparator.cpp)
add_executable(17 Source/17_fraudulent_activity_notifications/FraudulentActivityNotifications.cpp)
add_executable(18 Source/18_merge_sort_counting/MergeSortCounting.cpp)
add_executable(19 Ds/Sorting/Selection.cpp)
add_executable(20 Ds/Sorting/Insertion.cpp)
add_executable(21 Ds/Sorting/Shell.cpp)
add_executable(22 Ds/Sorting/Merge.cpp)
add_executable(23 Ds/Sorting/Quick.cpp)
add_executable(24 Source/19_making_anagrams/MakingAnagrams.cpp)
add_executable(25 Source/20_alternating_characters/AlternatingCharacters.cpp)
add_executable(26 Source/21_valid_string/ValidString.cpp)

target_link_libraries(
        algo
        PRIVATE
        algo_lib
)

#cmake -H. -Bcmake-build-debug && cd cmake-build-debug && make all
