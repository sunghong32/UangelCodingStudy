//
//  main.swift
//  BackjoonCodingTest
//
//  Created by 민성홍 on 2023/08/18.
//  백준 1789: 수들의 합
//  메모리: 79508KB
//  시간: 12ms

import Foundation

let S: Int = Int(readLine()!)!
var n: Int = 0

while n * (n + 1) / 2 <= S {
    n += 1
}

print(n - 1)
