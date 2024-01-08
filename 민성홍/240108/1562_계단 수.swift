//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 1/8/24.
////  백준 1562: 계단 수
////  메모리: 82584 KB
////  시간: 160 ms

import Foundation

let N = Int(readLine()!)!
let MOD = 1000000000

var dp = Array(repeating: Array(repeating: Array(repeating: 0, count: 10), count: 1 << 10), count: N + 1)

if N < 10 {
    print(0)
} else {
    for lastDigit in 1...9 {
        dp[1][1 << lastDigit][lastDigit] = 1
    }

    for length in 2...N {
        for usedNumbers in 0..<(1 << 10) {
            for lastDigit in 0...9 {
                let newUsedNumbers = usedNumbers | (1 << lastDigit)

                if lastDigit > 0 {
                    dp[length][newUsedNumbers][lastDigit] += dp[length - 1][usedNumbers][lastDigit - 1]
                    dp[length][newUsedNumbers][lastDigit] %= MOD
                }

                if lastDigit < 9 {
                    dp[length][newUsedNumbers][lastDigit] += dp[length - 1][usedNumbers][lastDigit + 1]
                    dp[length][newUsedNumbers][lastDigit] %= MOD
                }
            }
        }
    }

    var result = 0
    for lastDigit in 0...9 {
        result += dp[N][1023][lastDigit]
        result %= MOD
    }

    print(result)
}
82584
