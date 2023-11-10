//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 11/10/23.
////  백준 8958: OX퀴즈
////  메모리: 79508 KB
////  시간: 12 ms

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    var count: Int = 0
    var result: Int = 0
    let oxArray = Array(readLine()!)

    oxArray.forEach {
        if $0 == "O" {
            count += 1
            result += count
        }

        if $0 == "X" {
            count = 0
        }
    }

    print(result)
}
