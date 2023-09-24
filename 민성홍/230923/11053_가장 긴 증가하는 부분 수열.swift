//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/24.
//  백준 11053: 가장 긴 증가하는 부분 수열
//  메모리: 69104KB
//  시간: 16ms

import Foundation

let N: Int = Int(readLine()!)!
let A: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }

var dp = Array(repeating: 1, count: N + 1)

for i in 1..<A.count {
    for j in 0..<i {
        if A[j] < A[i] {
            dp[i] = max(dp[i], dp[j] + 1)
        }
    }
}

print(dp.max()!)
