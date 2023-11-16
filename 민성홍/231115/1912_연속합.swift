//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 11/15/23.
//  백준 1912: 연속합
//  메모리: 86524 KB
//  시간: 36 ms

import Foundation

let n = Int(readLine()!)!
let nums = readLine()!.split(separator: " ").map { Int($0)! }

var dp = Array(repeating: -1001, count: 100001)

dp[0] = nums[0]

for i in 1..<n{
    dp[i] = max(nums[i],dp[i - 1] + nums[i])
}

print(dp.max()!)
