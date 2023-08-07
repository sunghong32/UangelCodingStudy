//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/07.
// 백준 10101: 삼각형 외우기
// 메모리: 79512KB
// 시간: 12ms

import Foundation

var numArray: [Int] = Array(repeating: 0, count: 3)

for i in 0..<3 {
    numArray[i] = Int(readLine()!)!
}

func check() -> String {
    var result: String = ""
    let total: Int = numArray.reduce(0, +)

    if total == 180 {
        if Set<Int>(numArray).count == 1 {
            result = "Equilateral"
        } else if Set<Int>(numArray).count == 2 {
            result = "Isosceles"
        } else {
            result = "Scalene"
        }
    } else {
        result = "Error"
    }

    return result
}

print(check())
