//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/07/26.
// 백준 1439: 뒤집기
// 메모리: 79508KB
// 시간: 12ms

import Foundation

let s: [Int] = Array(readLine()!).map { Int(String($0))! }
var oneCount: Int = 0
var zeroCount: Int = 0
var result: Int = 0

for i in 0..<s.count - 1 {
    if s[i] != s[i + 1] {
        if s[i] == 0 {
            zeroCount += 1
        } else {
            oneCount += 1
        }
    }
}

result = oneCount > zeroCount ? oneCount : zeroCount

print(result)
