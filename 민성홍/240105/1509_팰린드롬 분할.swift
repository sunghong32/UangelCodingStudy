//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 1/5/24.
//  백준 1509: 팰린드롬 분할
//  메모리: 85712 KB
//  시간: 132 ms

import Foundation

let str = readLine()!
let N = str.count
let arr = Array(str)
var dp = Array(repeating: 0, count: N)
var isPal = Array(repeating: Array(repeating: false, count: N), count: N)

for i in 0..<N {
    isPal[i][i] = true
}

for i in 0..<N-1 {
    if arr[i] == arr[i+1] {
        isPal[i][i+1] = true
    }
}

for d in 2..<N {
    for i in 0..<N-d {
        if arr[i] == arr[i+d] && isPal[i+1][i+d-1] {
            isPal[i][i+d] = true
        }
    }
}

for i in 0..<N {
    var min = Int.max
    for j in 0...i {
        if isPal[j][i] {
            if j == 0 {
                min = 0
            } else if dp[j-1] < min {
                min = dp[j-1]
            }
        }
    }
    dp[i] = min + 1
}

print(dp[N-1])

