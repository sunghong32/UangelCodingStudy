//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/15.
//  백준 9084: 동전
//  메모리: 79516KB
//  시간: 12ms

import Foundation

func check() {
    let T: Int = Int(readLine()!)!

    for _ in 0..<T {
        let _: Int = Int(readLine()!)!
        let coins: [Int] = readLine()!.split(separator: " ").map { Int($0)! }

        let M: Int = Int(readLine()!)!

        var dp: [Int] = Array(repeating: 0, count: M + 1)
//        dp[0] = 1

        for coin in coins {
            if coin > M {
                continue
            }

            dp[coin] += 1

            if coin + 1 > M {
                continue
            }

            for i in (coin + 1)..<(M + 1)  {
                dp[i] += dp[i - coin]
            }
        }

        print(dp[M])
    }
}

check()
