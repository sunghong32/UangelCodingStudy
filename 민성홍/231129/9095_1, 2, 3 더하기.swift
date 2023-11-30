//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/30.
//  백준 9095: 1, 2, 3 더하기
//  메모리: 79508 KB
//  시간: 12 ms

import Foundation

func countWays(n: Int) -> Int {
    var memo = [Int: Int]()
    return countWaysUtil(n: n, memo: &memo)
}

func countWaysUtil(n: Int, memo: inout [Int: Int]) -> Int {
    if let val = memo[n] {
        return val
    }

    if n < 0 {
        return 0
    } else if n == 0 {
        return 1
    } else {
        memo[n] = countWaysUtil(n: n - 1, memo: &memo) + countWaysUtil(n: n - 2, memo: &memo) + countWaysUtil(n: n - 3, memo: &memo)
        return memo[n]!
    }
}

let n = Int(readLine()!)!

for _ in 0..<n {
    print(countWays(n: Int(readLine()!)!))
}
