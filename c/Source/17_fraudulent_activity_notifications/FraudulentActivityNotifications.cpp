#include <iostream>
#include <vector>
#include <map>

void add(int el, std::map<int, int> &map) {
    map[el]++;
}

void del(int el, std::map<int, int> &map) {
    if (--map[el] == 0) {
        map.erase(el);
    }
}

double median(const std::map<int, int> &map, int firstMed, const bool isComplexMed) {
    int sum = 0;
    for (auto pair = map.begin(); pair != map.end(); pair++) {
        if (sum + pair->second <= firstMed) {
            sum += pair->second;
        } else {
            if (!isComplexMed) {
                return pair->first;
            } else {
                firstMed++;
                if (sum + pair->second > firstMed) {
                    return pair->first;
                }
                return double(pair->first + (++pair)->first) / 2;
            }
        }
    }
    return -1;
}

int activityNotifications(std::vector<int> expenditure, int d) {
    int notifications = 0;
    int firstMed;
    bool isComplexMed = d % 2 == 0;
    if (isComplexMed) {
        firstMed = (d / 2) - 1;
    } else {
        firstMed = d / 2;
    }
    std::map<int, int> map = std::map<int, int>();
    for (int i = 0; i < d; ++i) {
        add(expenditure[i], map);
    }
    int lastDay = expenditure.size() - d;
    for (int i = 0; i < lastDay; ++i) {
        int currentDay = expenditure[i + d];
        double med = median(map, firstMed, isComplexMed) * 2;
        if (currentDay >= med) {
            notifications++;
        }
        if (i + 1 < lastDay) {
            add(currentDay, map);
            del(expenditure[i], map);
        } else {
            return notifications;
        }
    }
    return notifications;
}


int main() {
    std::cout << activityNotifications({2, 3, 4, 2, 3, 6, 8, 4, 5}, 5) << std::endl; //2
    std::cout << activityNotifications({1, 2, 3, 4, 4}, 4) << std::endl; //0
    std::cout << activityNotifications({10, 20, 30, 40, 50}, 3) << std::endl; //1
};
