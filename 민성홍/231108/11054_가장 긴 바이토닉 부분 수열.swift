//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/09.
//  백준 11054: 가장 긴 바이토닉 부분 수열
//  메모리: 79516 KB
//  시간: 28 ms

import Foundation

let N = Int(readLine()!)!
let nArray = readLine()!.split(separator: " ").map { Int(String($0))!}
let lArray = Array(nArray.reversed())

var rdp = Array(repeating: 1, count: N)
var ldp = Array(repeating: 1, count: N)
var dp = Array(repeating: 1, count: N)

for i in 1..<N {
    for j in 0..<i {
        if nArray[j] < nArray[i] {
            rdp[i] = max(rdp[i], rdp[j] + 1)
        }
    }
}

for i in 1..<N {
    for j in 0..<i {
        if lArray[j] < lArray[i] {
            ldp[i] = max(ldp[i], ldp[j] + 1)
        }
    }
}

ldp = Array(ldp.reversed())
for i in 0..<rdp.count {
    dp[i] = rdp[i] + ldp[i]
}

print(dp.max()! - 1)
