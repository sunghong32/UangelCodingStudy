//
//  9251.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/27.
//  백준 9251: LCS
//  메모리: 87392KB
//  시간: 48ms

import Foundation

let x = readLine()!.map{ String($0) }
let y = readLine()!.map{ String($0) }
var dp = Array(repeating: Array(repeating: 0, count: y.count + 1), count: x.count + 1)

for i in 1...x.count {
    for j in 1...y.count {
        if x[i - 1] == y [j - 1] {
            dp[i][j] = dp[i - 1][j - 1] + 1
        } else {
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        }
    }
}

print(dp[x.count][y.count])
