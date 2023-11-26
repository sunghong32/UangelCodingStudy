//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/24.
////  백준 2437: 저울
////  메모리: 79516 KB
////  시간: 12 ms

import Foundation

let N = Int(readLine()!)!
var weights = readLine()!.split(separator: " ").map { Int($0)!}

weights.sort()

var totalSum = 0 // 누적합

for weight in weights {
    if weight > totalSum+1 {
        break
    }
    totalSum += weight
}

print(totalSum+1)
