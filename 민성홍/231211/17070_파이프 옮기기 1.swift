//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/11/23.
//  백준 17070: 파이프 옮기기 1
//  메모리: 69108 KB
//  시간: 8 ms

import Foundation

let N = Int(readLine()!)!
var house: [[Int]] = []
var dp: [[[Int]]] = Array(repeating: Array(repeating: Array(repeating: 0, count: 3), count: N), count: N)

for _ in 0..<N {
    house.append(readLine()!.split(separator: " ").map { Int($0)! })
}

dp[0][1][0] = 1

for i in 0..<N {
    for j in 0..<N {
        if j+1 < N, house[i][j+1] == 0 {
            dp[i][j+1][0] += dp[i][j][0] + dp[i][j][2]
        }

        if i+1 < N, house[i+1][j] == 0 {
            dp[i+1][j][1] += dp[i][j][1] + dp[i][j][2]
        }

        if i+1 < N, 
            j+1 < N,
            house[i+1][j+1] == 0,
           house[i+1][j] == 0,
            house[i][j+1] == 0
        {
            dp[i+1][j+1][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2]
        }
    }
}

print(dp[N-1][N-1].reduce(0, +))
