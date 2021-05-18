cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

project(ds_and_algo_project VERSION 0.0.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_compile_options(-std=c++2a)

configure_file(test/tester/SourceDirLocation.h.in ${PROJECT_SOURCE_DIR}/test/tester/SourceDirLocation.h)

add_library(
        algo_lib
        algo/exers/01_string_length/StringLength.cpp
        algo/exers/02_hk_dynamic_array/DynamicArray.cpp
        algo/exers/03_reverse_array/ReverseArray.cpp
        algo/exers/04_left_shift/LeftShift.cpp
        algo/exers/05_matching_strings/MatchingStrings.cpp
        algo/exers/06_plus_minus/PlusMinus.cpp
        algo/exers/07_sales_by_match/SalesByMatch.cpp
        algo/exers/08_counting_valley/CountingValley.cpp
        algo/exers/09_jumping_on_cloud/JumpingOnCloud.cpp
        algo/exers/10_repeated_string/RepeatedString.cpp
        algo/exers/11_new_year_chaos/NewYearChaos.cpp
        algo/exers/12_ransom_note/RansomNote.cpp
        algo/exers/13_frequency_query/FrequencyQuery.cpp
        algo/exers/14_bubble_sort/BubbleSort.cpp
        algo/exers/15_mark_and_toys/MarkAndToys.cpp
        algo/exers/16_comparator/Comparator.cpp
        algo/exers/17_fraudulent_activity_notifications/FraudulentActivityNotifications.cpp
        algo/exers/18_merge_sort_counting/MergeSortCounting.cpp
        algo/sorting/Selection.cpp
        algo/sorting/Insertion.cpp
        algo/sorting/Shell.cpp
        algo/sorting/Merge.cpp
        algo/sorting/Quick.cpp
        algo/exers/19_making_anagrams/MakingAnagrams.cpp
        algo/exers/20_alternating_characters/AlternatingCharacters.cpp
        algo/exers/21_valid_string/ValidString.cpp
        algo/exers/22_special_string/SpecialString.cpp
        algo/exers/23_common_child/CommonChild.cpp
        algo/exers/24_cream_parlor/CreamParlor.cpp
        algo/exers/25_greedy_point_cover/GreedyPointCover.cpp
        algo/exers/26_max_backpack/MaxBackPack.cpp
        algo/exers/27_term_sum/TermSum.cpp
        algo/exers/28_absolute_minimum_diff/AbsoluteMinimumDiff.cpp
        algo/exers/29_lucky_balance/LuckyBalance.cpp
        algo/exers/30_greedy_florist/GreedyFlorist.cpp
        algo/exers/31_max_min/MaxMin.cpp
        algo/exers/32_specific_linked_list/SpecificLinkedList.cpp
        algo/exers/33_flipping_bits/FlippingBits.cpp
        algo/exers/34_special_division/SpecialDivision.cpp
)

add_library(
        ds_lib
        ds/bag/Bag.cpp
        ds/queue/Queue.cpp
)

add_library(
        test_lib
        test/tester/Tester.cpp
        test/cases/01_string_length/StringLengthTest.cpp
        test/cases/02_hk_dynamic_array/DynamicArrayTest.cpp
        algo/exers/01_string_length/StringLength.cpp
        algo/exers/02_hk_dynamic_array/DynamicArray.cpp
        test/TestRunner.cpp
)

add_executable(testRunner test/TestRunner.cpp)
add_executable(03 algo/exers/03_reverse_array/ReverseArray.cpp)
add_executable(04 algo/exers/04_left_shift/LeftShift.cpp)
add_executable(05 algo/exers/05_matching_strings/MatchingStrings.cpp)
add_executable(06 algo/exers/06_plus_minus/PlusMinus.cpp)
add_executable(07 algo/exers/07_sales_by_match/SalesByMatch.cpp)
add_executable(08 algo/exers/08_counting_valley/CountingValley.cpp)
add_executable(09 algo/exers/09_jumping_on_cloud/JumpingOnCloud.cpp)
add_executable(10 algo/exers/10_repeated_string/RepeatedString.cpp)
add_executable(11 algo/exers/11_new_year_chaos/NewYearChaos.cpp)
add_executable(12 algo/exers/12_ransom_note/RansomNote.cpp)
add_executable(13 algo/exers/13_frequency_query/FrequencyQuery.cpp)
add_executable(14 algo/exers/14_bubble_sort/BubbleSort.cpp)
add_executable(15 algo/exers/15_mark_and_toys/MarkAndToys.cpp)
add_executable(16 algo/exers/16_comparator/Comparator.cpp)
add_executable(17 algo/exers/17_fraudulent_activity_notifications/FraudulentActivityNotifications.cpp)
add_executable(18 algo/exers/18_merge_sort_counting/MergeSortCounting.cpp)
add_executable(19 algo/sorting/Selection.cpp)
add_executable(20 algo/sorting/Insertion.cpp)
add_executable(21 algo/sorting/Shell.cpp)
add_executable(22 algo/sorting/Merge.cpp)
add_executable(23 algo/sorting/Quick.cpp)
add_executable(24 algo/exers/19_making_anagrams/MakingAnagrams.cpp)
add_executable(25 algo/exers/20_alternating_characters/AlternatingCharacters.cpp)
add_executable(26 algo/exers/21_valid_string/ValidString.cpp)
add_executable(27 algo/exers/22_special_string/SpecialString.cpp)
add_executable(28 algo/exers/23_common_child/CommonChild.cpp)
add_executable(29 algo/exers/24_cream_parlor/CreamParlor.cpp)
add_executable(30 algo/exers/25_greedy_point_cover/GreedyPointCover.cpp)
add_executable(31 algo/exers/26_max_backpack/MaxBackPack.cpp)
add_executable(32 algo/exers/27_term_sum/TermSum.cpp)
add_executable(33 algo/exers/28_absolute_minimum_diff/AbsoluteMinimumDiff.cpp)
add_executable(34 algo/exers/29_lucky_balance/LuckyBalance.cpp)
add_executable(35 algo/exers/30_greedy_florist/GreedyFlorist.cpp)
add_executable(36 algo/exers/31_max_min/MaxMin.cpp)
add_executable(37 algo/exers/32_specific_linked_list/SpecificLinkedList.cpp)
add_executable(38 algo/exers/33_flipping_bits/FlippingBits.cpp)
add_executable(39 algo/exers/34_special_division/SpecialDivision.cpp)

add_executable(bag ds/bag/BagTest.cpp)
add_executable(queue ds/queue/QueueTest.cpp)

target_include_directories(
        algo_lib
        PUBLIC
        algo/exers/00_global
        algo/exers/01_string_length
        algo/exers/02_hk_dynamic_array
        test/cases/01_string_length
        test/cases/02_hk_dynamic_array
        test/tester
)

target_include_directories(
        ds_lib
        PUBLIC
        ds/bag
        ds/utils
        ds/queue
)

target_include_directories(
        test_lib
        PUBLIC
        test/cases/01_string_length
        test/cases/02_hk_dynamic_array
        algo/exers/01_string_length
        algo/exers/02_hk_dynamic_array
        test/tester
)

target_link_libraries(
        bag
        ds_lib
)

target_link_libraries(
        queue
        ds_lib
)

target_link_libraries(
        testRunner
        algo_lib
        ds_lib
        test_lib
)

#cmake -H. -Bcmake-build-debug && cd cmake-build-debug && make all
