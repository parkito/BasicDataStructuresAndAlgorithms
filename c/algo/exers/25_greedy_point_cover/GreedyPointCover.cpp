#include <iostream>
#include <utility>
#include <vector>

using Segment = std::pair<int, int>;

bool X_less(const Segment &s1, const Segment &s2) { return s1.second < s2.second; }
//    std::sort(segments.begin(), segments.end(), &X_less);

std::vector<int> get_covering_set(std::vector<Segment> segments) {
    std::sort(segments.begin(), segments.end(), [](const Segment &s1, const Segment &s2) {
        return s1.second < s2.second;
    });
    std::vector<int> result;
    Segment &currentSegment = segments[0];
//    for (int i = 1; i < segments.size(); ++i) {
//        if (i == segments.size() - 1) {
//            result.push_back(currentSegment.second);
//            if (currentSegment.second < segments[i].first) {
//                result.push_back(segments[i].first);
//            }
//            break;
//        }
//        if (currentSegment.second < segments[i].first) {
//            result.push_back(currentSegment.second);
//            currentSegment = segments[i];
//        }
//    }
    int beg = -1;
    for (auto s : segments) {
        if (beg < s.first) {
            beg = s.second;
            result.push_back(beg);
        }
    }
    return result;
}

int main(void) {
    int segments_count;
    std::cin >> segments_count;
    std::vector<Segment> segments(segments_count);
    for (auto &s:segments) {
        std::cin >> s.first >> s.second;
    }

    auto points = get_covering_set(std::move(segments));
    std::cout << points.size() << std::endl;
    for (auto point:points) {
        std::cout << point << " ";
    }
    std::cout << std::endl;
}
