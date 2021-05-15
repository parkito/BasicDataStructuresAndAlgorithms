#include <iostream>
#include <vector>
//Задача на программирование: различные слагаемые
//По данному числу 1≤n≤10^9 найдите максимальное число k, для которого n можно представить как сумму k различных
//* натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
//* Sample Input 1:
//* 4
//* Sample Output 1:
//* 2
//* 1 3
//*
//* Sample Input 2:
//* 6
//* Sample Output 2:
//* 3
//* 1 2 3


// The idea: manually calculation max terms for 1,2,3....n, we can see that:
//the solution is arithmetic progression with diff =1 + the last term that can be non a member of progression
//So: 1 + 2 + 3 + 4 + ... + S = n

//The greedy algorithm: the max number of terms is achievable only in a case of using the smallest members of the sequence.
//Greedy step: use the smallest members
//Greedy step progression: use smallest numbers until it possible and add the reminder
int main() {
    int n;
    std::cin >> n;
    int term = 1;
    std::vector<int> vec;
    //going 1,2,3,4,5....
    while (term < n - term) {
        vec.push_back(term);
        n -= term++;
    }
    //adding the last term
    vec.push_back(n);
    std::cout << vec.size() << std::endl;
    for (auto &v:vec) {
        std::cout << v << " ";
    }

    return 0;
}