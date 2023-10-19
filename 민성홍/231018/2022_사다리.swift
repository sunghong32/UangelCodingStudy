//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/18.
//  백준 2022: 사다리
//  메모리: 79508 KB
//  시간: 12 ms

import Foundation

let XYC = readLine()?.split(separator: " ").map { Double($0)! }

func check(mid: Double, x: Double, y: Double, c: Double) -> Double {
    let h1 = sqrt((x * x) - (mid * mid))
    let h2 = sqrt((y * y) - (mid * mid))

    return h1 * h2 / (h1 + h2)
}

func solve(x: Double, y: Double, c: Double) -> String {
    var left = 0.0
    var right = min(x,y)

    for _ in 0..<10000 {
        let mid = (left + right) / 2.0

        if check(mid: mid,x: x, y: y, c: c) > c {
            left = mid
        } else {
            right = mid
        }
    }

    return String(format: "%.3f", left)
}

print(solve(x: XYC![0], y: XYC![1], c: XYC![2]))
